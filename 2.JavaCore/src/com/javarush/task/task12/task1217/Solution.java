package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.


Требования:
1. Класс Solution должен содержать интерфейс Fly.
2. Класс Solution должен содержать интерфейс Run.
3. Класс Solution должен содержать интерфейс Swim.
4. Интерфейс Fly должен содержать один метод.
5. Интерфейс Run должен содержать один метод.
6. Интерфейс Swim должен содержать один метод.
*/

public class Solution {
    public static void main(String[] args) {

    }


    public interface Fly {
        void setAltitude(int meters);
    }

    public interface Run {
        void setSpeedRun(int kmPerHour);
    }

    public interface Swim {
        void setSpeedSwim(int kmPerHour);
    }

}
