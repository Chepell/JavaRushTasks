package com.javarush.task.task13.task1305;

/* 
Четыре ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.


Требования:
1. Переменные объявленные в интерфейсе могут иметь только самый широкий уровень доступа(public).
2. Унаследоваться(extends) можно только от класса, для реализации интерфейсов используется ключевое слово implements.
3. Класс Hobby должен быть объявлен с модификатором доступа static.
4. Для доступа к переменной HOBBY нет необходимости создавать объект Dream.
5. Объявления интерфейсов не изменять.
*/

public class Solution {

    public static void main(String[] args) {
        // в первом вызове достаточно создать переменную типа Dream
        System.out.println(Dream.HOBBY.toString());
        System.out.println(new Hobby().toString());

    }


    // просто пустой интерфейс, типа заглушка
    interface Desire {
    }

    // интерфейс, который создает объект класса Hobby
    // т.е. как будто вызывает всё что есть в классе Hobby
    interface Dream {
        Hobby HOBBY = new Hobby();
    }

    public static class Hobby implements Dream, Desire {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}
