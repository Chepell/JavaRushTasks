package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        // создаю массив для хранения 2х объектов класса
        Solution[] solArray = new Solution[2];
        // создаю первый объект и помещаю в массив
        solArray[0] = new Solution();
        // в объекте обращаюсь к ячейке массива который должен хранить внутренние классы
        // и в каждой ячейке создаю по объекту внутреннего класса с
        // вызовом объекта Solution и вызове на нем конструктора InnerClass
        solArray[0].innerClasses[0] = solArray[0].new InnerClass();
        solArray[0].innerClasses[1] = solArray[0].new InnerClass();
        // повторяю все для второго объекта массива
        solArray[1] = new Solution();
        solArray[1].innerClasses[0] = solArray[1].new InnerClass();
        solArray[1].innerClasses[1] = solArray[1].new InnerClass();
        return solArray;
    }

    public static void main(String[] args) {

    }
}
