package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/
public class Solution {
    // защелка обратного отсчета, которую нужно вызвать один раз что бы пошло исполнение дальше
    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        // декрементирую защелку
        latch.countDown();
        // тут жду открытой защелки, дальше не иду,
        // но она уже открыта одним вызовом метода countDown
        latch.await();
        // метод вызывается если защелка открыта
        retrieveValue();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution().someMethod();
    }
}
