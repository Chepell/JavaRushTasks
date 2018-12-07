package com.javarush.task.task14.task1408;
// класс наследник от абстрактного класса
// с реализацие интерфейса
public class RussianHen extends Hen implements Country {
    // поля класса с инициализацией по умолчанию
    private int eggs = 30;
    private String country = RUSSIA;

    // геттер яйценостности
    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    // переопределение метода из суперкласса
    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), country, eggs);
    }
}