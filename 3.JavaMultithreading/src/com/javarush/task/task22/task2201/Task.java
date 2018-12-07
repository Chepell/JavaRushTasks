package com.javarush.task.task22.task2201;

// класс реализуюший интрефейс многопоточности
public class Task implements Runnable {
    // приватные поля класса
    private String initialString;
    private Solution solution;

    // публичный конструктор класса
    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    // реализация метода для многонитьевости
    @Override
    public void run() {
        // в переменную сохраняется имя текущего потока
        String name = Thread.currentThread().getName();
        // в другую переменную сохраняетя поле объекта
        String str = this.initialString;
        do {
            // печать имени и строки
            System.out.println(name + str);
            // теперь в строку сохраняется то что возвращает метод и идет проверка что строка не null и не пустая
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}
