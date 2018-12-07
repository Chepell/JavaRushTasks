package com.javarush.task.task15.task1529;

public class Plane implements Flyable {
    private int passengersCapacity;

    public Plane(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " can fly fast!");
    }
}
