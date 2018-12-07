package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private final int INTERVAL;


    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.INTERVAL = interval;
    }

    @Override
    public void run() {
        // исполнение в цикле с периодичностью INTERVAL и пока не будет прервана нить
        while (!Thread.currentThread().isInterrupted()) {
            // метод выбирает случайеым образом планшет из списка планшетов
            Tablet tablet = tablets.get((int) (ThreadLocalRandom.current().nextDouble() * tablets.size()));
            tablet.createTestOrder(); // для выбранного планшета создается случайный заказ
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}