package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 0;
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            try {
                i++;
                String key = String.valueOf(i);
                String value = String.format("Some text for %d", i);
                map.put(key, value);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
            }
        }
    }
}

