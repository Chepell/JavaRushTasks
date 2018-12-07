package com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private String name;
    // поле статичное, что бы можно было вызват его в статичном геттере
    private static Moon instance;

    // замена конструктора по умолчанию
    private Moon() {
        this.name = MOON;
    }

    public static Moon getInstance() {
        if (instance == null) instance = new Moon();
        return instance;
    }

}
