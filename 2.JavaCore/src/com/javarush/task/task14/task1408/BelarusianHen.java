package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country {
    private int eggs = 58;
    private String country = BELARUS;

    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), country, eggs);
    }
}