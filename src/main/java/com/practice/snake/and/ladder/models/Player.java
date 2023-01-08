package com.practice.snake.and.ladder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private String playerName;
    @Setter
    private Boolean hasWon;
    @Setter
    private Integer position;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hasWon = false;
        this.position = 0;
    }
}
