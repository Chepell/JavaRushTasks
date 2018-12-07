package com.javarush.task.task24.task2404;

import com.javarush.task.task24.task2404.HasHeight;
import com.javarush.task.task24.task2404.HasWidth;
import com.javarush.task.task24.task2404.Point;

/* 
Рефакторинг Rectangle
В классе Rectangle:
1. Измени методы getHeight и getWidth, чтобы они возвращали объекты типов HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создай локальные классы - реализации интерфейсов.
3. Переименуй getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажми Shift+F6).
4. Убери наследование интерфейсов в классе Rectangle.

P.S. Ожидается, что после внесения требуемых изменений, закомментированный код в методе станет рабочим и должен быть раскомментирован.


Требования:
1. В класса Rectangle должен быть реализован метод castToHasHeight.
2. В класса Rectangle должен быть реализован метод castToHasWidth.
3. Метод castToHasHeight должен возвращать объект типа HasHeight.
4. Метод castToHasWidth должен возвращать объект типа HasWidth.
5. Объект возвращаемый методом castToHasHeight должен вычислять высоту, как разницу между y координатами.
6. Объект возвращаемый методом castToHasWidth должен вычислять ширину, как разницу между x координатами.
7. Класс Rectangle не должен реализовывать интерфейс HasHeight.
8. Класс Rectangle не должен реализовывать интерфейс HasWidth.
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
//        System.out.println(getHeight(rectangle));
//        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    // методы класса Solution принимают объекты интерфейсов и возвращают методы объектов
    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }

    // статичный класс реализующий интерфейсы
    public static class Rectangle {
        // поля класса в виде объектов класса Point
        private Point point1;
        private Point point2;

        // публичный конструктор класса, принимающий параметрами координаты для двух точек
        public Rectangle(double x1, double y1, double x2, double y2) {
            // инициализация полей класса координатами
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        // имплементация методов интерфейсов
        public HasHeight castToHasHeight() {
            class Hh implements HasHeight {

                @Override
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            }
            return new Hh();

        }

        public HasWidth castToHasWidth() {
            class Hw implements HasWidth {

                @Override
                public double getWidth() {
                    return Math.abs(point1.getX() - point2.getX());
                }
            }
            return new Hw();
        }
    }
}
