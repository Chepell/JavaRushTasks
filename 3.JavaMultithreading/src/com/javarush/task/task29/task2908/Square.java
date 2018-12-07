package com.javarush.task.task29.task2908;

// класс реализует интерфейс с генериками аргумент, значение
public class Square implements Computable<Integer, Integer> {
    // реализация обязательного метода интерфейса
    @Override
    // метод возвращает значение а принимает аргумет
    public Integer compute(Integer integer) throws InterruptedException {
        // зачем-то распаковка в примитив, типа что бы просто перемножить
        int val = integer.intValue();
        return val * val;
//        return integer * integer;
    }
}
