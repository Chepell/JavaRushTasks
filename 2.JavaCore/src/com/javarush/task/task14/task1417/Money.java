package com.javarush.task.task14.task1417;

public abstract class Money {
    // поле количества
    private double amount;

    // конструктор
    public Money(double amount) {
        this.amount = amount;
    }

    // реализованный геттер
    public double getAmount() {
        return this.amount;
    }

    // абстрактные геттеры, реализую в конечных классах
    public abstract String getCurrencyName();
}

