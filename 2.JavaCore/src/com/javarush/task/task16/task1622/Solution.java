package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            SleepingThread st = new SleepingThread();
            st.join();
            st.interrupt();

        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {
                System.out.println(this);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                    return;
                }
                if (--countDownIndex == 0) return;
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
