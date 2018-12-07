package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.List;

/**
 * Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.
 *
 * Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.
 *
 * Кинуть исключение (throw) явно нельзя.
 *
 *
 * Требования:
 * 1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
 * 2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
 * 3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
 * 4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
 */

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object str = "dsd";
        Integer x = (Integer) str;
    }

    public void methodThrowsNullPointerException() {
        List<Integer> list = null;
        list.add(1);
    }

    public static void main(String[] args) {

    }
}
