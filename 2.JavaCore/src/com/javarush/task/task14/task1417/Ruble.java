package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    // обязательная реализация конструктора в классе наследника
    // т.к. он реализовывался в классе родителе
    public Ruble(double amount) {
        super(amount);
    }

    // реализация геттера, который в классе
    // родителе абстрактный и не имеет реализации
    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
