package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
    private int eggs = 35;
    private String country = MOLDOVA;

    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), country, eggs);
    }
}