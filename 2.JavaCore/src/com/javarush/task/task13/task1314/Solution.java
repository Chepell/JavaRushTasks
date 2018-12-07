package com.javarush.task.task13.task1314;

import java.awt.*;

/* 
Большая лисица — это такая лисица
1. Исправь класс BigFox так, чтобы программа компилировалась.


Требования:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод(getName).
3. В интерфейсе Animal должен быть объявлен метод getColor.
4. Класс BigFox должен быть потомком класса Fox.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal {
        // метод возвращающий переменную типа цвет
        // реализации нет, т.к. это интерфейс
        Color getColor();
    }

    public static abstract class Fox implements Animal {
        // метод абстрактного класса, реализован т.к. сам не абстрактный
        public String getName() {
            return "Fox";
        }
    }

    // наследник абстрактного класса
    public static class BigFox extends Fox {
        // реализация метода интерфейса
        private Color Color() {
            // возвращает конкретный цвет
            return Color.GRAY;
        }

        // геттер возвращающий цвет класса
        public Color getColor() {
            return Color();
        }
    }

}
