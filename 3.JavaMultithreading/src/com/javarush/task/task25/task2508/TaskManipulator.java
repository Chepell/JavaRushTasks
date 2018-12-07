package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    // поле-делегат
    private Thread thread;

    // реализация метода интфрейса Runnable для многопоточности
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        // цикл продолжается пока не будет прерван
        while (!thread.isInterrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // цикл без break не кончится
                // обязателен для схем когда используется sleep в while цикле
                // будет выброшенно исключение и без break тут цикл не завершится
                break;
            }
        }
    }


    @Override
    public void start(String threadName) {
        // метод создает поток и помещает в него ттекущий объект клааса и назначает имя
        thread = new Thread(this, threadName);
        // и запускает нить
        thread.start();
    }

    @Override
    public void stop() {
        // реализация прерывания нити
        thread.interrupt();
    }
}
