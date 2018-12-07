package com.javarush.task.task12.task1216;

/* 
Летать охота
Напиши свой public интерфейс Fly(летать).
Добавь в него два метода.


Требования:
1. Класс Solution должен содержать интерфейс Fly.
2. Интерфейс Fly должен быть публичным.
3. Интерфейс Fly должен содержать два метода.
4. Интерфейс Fly не должен иметь родителя.
*/

public class Solution {
    public static void main(String[] args) {

    }

    // имя интерфейса, как и класса пишется с большой буквы
    public interface Fly {

        // все методы интерфейсов публичные
        // и public просто не нужно уже писать
        void setAtlitude(int meters);

        int getSpeed();
    }

}
