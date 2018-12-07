package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

// класс наследуется от рекурсивной задачи
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) { // рекурсивный вызов
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork(); // запуск асинхронно, фактически рекурсивный вызов
            return task.join() + result;
        }
        return result; // базовый выход без рекурсии
    }
}


