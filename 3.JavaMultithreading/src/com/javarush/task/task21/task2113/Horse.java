package com.javarush.task.task21.task2113;

public class Horse {
    // поля класса
    private String name;
    private double speed;
    private double distance;

    // конструктор класса
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // методы
    public void move() {
        double rndmSpeedCoef = Math.random();
        distance += speed * rndmSpeedCoef;
    }

    public void print() {
        // лишнее действие, приведение типа к int просто отбросит дробную часть, что нам и нужно
//        int roundDist = (int) Math.floor(distance);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (int) distance; i++) sb.append(".");
        sb.append(name);
        String horseTrack = sb.toString();
        System.out.println(horseTrack);
    }
}
