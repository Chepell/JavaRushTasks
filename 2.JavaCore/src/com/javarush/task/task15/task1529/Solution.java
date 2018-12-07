package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane", то считать второй параметр типа int(количество пассажиров),
    статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().


Требования:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
2. Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован метод public static void reset().
5. Метод reset должен считывать строки с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset.
*/

public class Solution {
    public static void main(String[] args) {

    }

    // в котором можно вызвать выполнение метода до входа в main
    // статик-блок
    static {
        reset();
    }

    // поле класса, принимающий объекты реализующие интерфейс Flyable
    public static Flyable result;

    // реализация метода
    public static void reset() {

        String input = "";

        // создание буфера помещаю в try
        // тогда по окончании работы он закрывается сам
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("You didn't input string!");
//            e.printStackTrace();
        }

        if ("helicopter".equalsIgnoreCase(input)) {
            result = new Helicopter();
        }

        if ("plane".equalsIgnoreCase(input)) {
            int inputInt = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                inputInt = Integer.parseInt(reader.readLine());
                reader.close();
            } catch (IOException | NumberFormatException e) {
                System.out.println("You should input positive integer number");
//                e.printStackTrace();
            }
            result = new Plane(inputInt);
        }

    }
}
