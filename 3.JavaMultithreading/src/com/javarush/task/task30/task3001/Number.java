package com.javarush.task.task30.task3001;

// класс чисел
public class Number {
    private NumerationSystem numerationSystem; // тип числа по основанию, из enum
    private String digit; // само число в виде строки

    // конструктор
    public Number(NumerationSystem numerationSystem, String digit) {
        this.numerationSystem = numerationSystem;
        this.digit = digit;
    }

    // геттеры полей
    public NumerationSystem getNumerationSystem() {
        return numerationSystem;
    }

    public String getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return "Number{" +
                "numerationSystem=" + numerationSystem +
                ", digit='" + digit + '\'' +
                '}';
    }
}
