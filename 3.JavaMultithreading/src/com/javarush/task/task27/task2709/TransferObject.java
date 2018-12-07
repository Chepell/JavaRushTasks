package com.javarush.task.task27.task2709;

// Требования:
//3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
//4. Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того, как оно пропадет.
//5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false
// и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.
//6. Метод put класса TransferObject должен устанавливать флаг isValuePresent
// в true и уведомлять другие нити ожидающие освобождения монитора после обновления значение поля value.
public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
//        while (!isValuePresent) {
//            // не идем дальше пока значения нет
//        }
//        isValuePresent = false;
//        System.out.println("Got: " + value);
//        notifyAll();
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return value;
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        try {
            return value;
        } finally {
            notifyAll();
        }
    }

    public synchronized void put(int value) {
//        while (isValuePresent) {
//            // дальше не идем пока значение есть
//        }
//        isValuePresent = true;
//        this.value = value;
//        notifyAll();
//        System.out.println("Put: " + value);
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        notifyAll();
    }
}