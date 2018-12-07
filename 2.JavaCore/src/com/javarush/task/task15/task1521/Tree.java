package com.javarush.task.task15.task1521;

/*
ООП. Перегрузка
1. В классе Tree перегрузи метод info(Object s) два раза так,
    чтобы получилось три метода info(Object s), info(Number s), info(String s).
1.1. Разберись в методе info(Object s). Сделай по аналогии функционал новых методов.
1.2. Например, для метода info(Number s) результат может быть таким
    "Дерево № 123 , метод Number, параметр Short".

4. Метод info(Number s) должен выводить на экран строку аналогичную строке из метода info(Object s),
    заменив лишь фразу("метод Object" на "метод Number").
5. Метод info(String s) должен выводить на экран строку аналогичную строке из метода info(Object s),
    заменив лишь фразу("метод Object" на "метод String").
 */

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(Number s) {
        System.out.println(String.format("Дерево № %d , метод Number, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(String s) {
        System.out.println(String.format("Дерево № %d , метод String, параметр %s", number, s.getClass().getSimpleName()));
    }

}
