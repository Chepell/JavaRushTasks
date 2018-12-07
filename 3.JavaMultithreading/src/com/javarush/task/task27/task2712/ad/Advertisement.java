package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration; // in sec
    private long amountPerOneDisplaying;


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    // in sec
    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    // on cents
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        //Бросать UnsupportedOperationException, если количество показов не положительное число
        if (hits <= 0) throw new UnsupportedOperationException();
        //Уменьшать доступное количество показов
        hits--;
    }

    public String toString() {
        return String.format("%s is displaying... %d, %d",
                name, getAmountPerOneDisplaying(), getAmountPerOneDisplaying() / duration * 1000);
    }
}