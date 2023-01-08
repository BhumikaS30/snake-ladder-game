package com.practice.snake.and.ladder;

import java.util.Scanner;

import com.practice.snake.and.ladder.models.Game;
import com.practice.snake.and.ladder.models.Player;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter board size");
        int boardSize = scanner.nextInt();
        System.out.println("Please enter number of players");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Please enter number of snakes");
        int numberOfSnakes = scanner.nextInt();
        System.out.println("Please enter number of ladders");
        int numberOfLadder = scanner.nextInt();

        Game game = new Game(numberOfLadder, numberOfSnakes, boardSize);

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Please enter player name");
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }
        game.playGame();
    }

}
