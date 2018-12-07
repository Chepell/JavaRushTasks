package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private String name;
    private static Earth instance;

    private Earth() {
        this.name = EARTH;
    }

    public static Earth getInstance() {
        if (instance == null) instance = new Earth();
        return instance;
    }

}
