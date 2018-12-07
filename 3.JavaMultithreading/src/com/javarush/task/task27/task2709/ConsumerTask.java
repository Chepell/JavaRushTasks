package com.javarush.task.task27.task2709;

// метод реализующий интерфейс многопоточности
public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        // в конструкторе класса создаю нить, передаю в нее текущий
        // объект и сразу стартую нить
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        while (!stopped) {
            synchronized (transferObject) {
                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}