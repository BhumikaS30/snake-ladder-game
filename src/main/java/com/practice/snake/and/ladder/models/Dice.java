package com.practice.snake.and.ladder.models;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@AllArgsConstructor
@Getter
public class Dice {

    private Integer minValue;

    private Integer maxValue;

    private Integer currentValue;

    public int roll(){ return nextInt(minValue, maxValue + 1); }

}
