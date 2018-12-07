package com.javarush.task.task29.task2908;

/* Argument and Value are generic types*/
public interface Computable<Argument, Value> {
    // в интерфейсе сигнатура единственного метода который нужно реализовывать в наследниках
    // интерфейс параметризирован аргументом и значением
    // метод принимает аргумент и возвращает значение
    Value compute(Argument argument) throws InterruptedException;
}
