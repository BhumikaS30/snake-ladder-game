package com.practice.snake.and.ladder.models;

import lombok.Getter;

@Getter
public class Board {

    private Integer boardSize;

    private Integer start;

    private Integer end;

    public Board(Integer boardSize) {
        this.boardSize = boardSize;
        this.start = 1;
        this.end = start + boardSize - 1;
    }
}
