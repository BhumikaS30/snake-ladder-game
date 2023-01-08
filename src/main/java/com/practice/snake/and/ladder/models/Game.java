package com.practice.snake.and.ladder.models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;

public class Game {

    private Board board;

    private Dice dice;

    private Queue<Player> players;

    private List<Snake> snakes;

    private List<Ladder> ladders;

    private Integer numberOfSnakes;

    private Integer numberOfLadders;

    public Game(int numberOfLadders, int numberOfSnakes, int boardSize) {
        this.players = new ArrayDeque<>();
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        this.snakes = new ArrayList<>(numberOfSnakes);
        this.ladders = new ArrayList<>(numberOfLadders);
        this.board = new Board(boardSize);
        this.dice = new Dice(1, 6, 2);
        initBoard(boardSize, numberOfSnakes, numberOfLadders);
    }

    public void initBoard(Integer boardSize, Integer numberOfSnakes, Integer numberOfLadders) {

        Set<String> overLapSet = new HashSet<>();

        for (int i = 0; i < numberOfSnakes; i++) {
            while (true) {
                int head = RandomUtils.nextInt(1, boardSize - 1);
                int tail = RandomUtils.nextInt(1, boardSize - 1);
                if (tail >= head) {
                    continue;
                }
                String headAndTailPair = String.valueOf(head) + tail;
                if (!overLapSet.contains(headAndTailPair)) {
                    snakes.add(new Snake(head, tail));
                    overLapSet.add(headAndTailPair);
                    break;
                }
            }
        }

        for (int i = 0; i < numberOfLadders; i++) {
            while (true) {
                int start = RandomUtils.nextInt(1, boardSize - 1);
                int end = RandomUtils.nextInt(1, boardSize - 1);
                if (end <= start) {
                    continue;
                }
                String startAndEndPair = String.valueOf(start) + end;
                if (!overLapSet.contains(startAndEndPair)) {
                    ladders.add(new Ladder(start, end));
                    overLapSet.add(startAndEndPair);
                    break;
                }
            }

        }

    }

    public void playGame() {

        while (true) {

            Player player = players.poll();
            int val = dice.roll();

            int newPosition = player.getPosition() + val;

            if (newPosition > board.getEnd()) {
                players.offer(player);
            } else {
                player.setPosition(getNewPosition(newPosition));
                if (newPosition == board.getEnd()) {
                    player.setHasWon(true);
                    System.out.println("Player " + player.getPlayerName() + " Won.");
                } else {
                    System.out.println("Setting " + player.getPlayerName() + "'s new position to " + player.getPosition());
                    players.offer(player);
                }
            }

            if (players.size() < 2) {
                break;
            }
        }

    }

    private Integer getNewPosition(int newPosition) {

        for (Snake snake : snakes) {
            if (newPosition == snake.getHead()) {
                System.out.println("Snake Bit");
                newPosition = snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (newPosition == ladder.getLadderStart()) {
                System.out.println("Climbed ladder");
                newPosition = ladder.getLadderEnd();
            }
        }
        return newPosition;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
