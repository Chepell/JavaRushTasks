package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int time) {
        duration = time;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        String str = Arrays.toString(Dish.values());
        // отрзаю у строки скобки по краям и возвращаю
        return str.substring(1, str.length() - 1);
    }
}


