package com.javarush.task.task29.task2909.car;

import java.util.Date;

abstract public class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    public final int MAX_TRUCK_SPEED = 80;
    public final int MAX_SEDAN_SPEED = 120;
    public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    // фабричный метод создания объекта класса
    // причем исходя из поданного параметра type создается объект нужного класса наследника
    public static Car create(int type, int numberOfPassengers) {
        Car returnObject = null;
        if (type == 0) {
            returnObject = new Truck(numberOfPassengers);
        } else if (type == 1) {
            returnObject = new Sedan(numberOfPassengers);
        } else if (type == 2) {
            returnObject = new Cabriolet(numberOfPassengers);
        }
        return returnObject;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) return false;
        return true;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) return getSummerConsumption(length);
        return getWinterConsumption(length);
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }

    // 12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
    //операторы (используй метод canPassengersBeTransferred()).
    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;

//            return 0;
//        if (fuel <= 0)
//            return 0;
//
//        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    //12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
    //startMoving(), чтобы в нем не было повторяющихся вызовов функций.
    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) fastenPassengersBelts();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    //12.3. Замена магического числа символьной константой. Замени магические числа в методе
    //getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
    //MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
    abstract public int getMaxSpeed();
}