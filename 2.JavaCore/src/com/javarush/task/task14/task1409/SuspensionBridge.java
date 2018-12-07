package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    private final int cars = 25;
    @Override
    public int getCarsCount() {
        return cars;
    }
}
