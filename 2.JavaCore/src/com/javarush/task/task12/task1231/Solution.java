package com.javarush.task.task12.task1231;

/* 
Ненужные абстракции
Необходимо расставить правильно ключевые слова abstract, чтобы программа компилировалась.
Добавь там где надо и удали там, где они не нужны.


Требования:
1. Класс Pegas должен реализовывать интерфейс Fly.
2. Класс Pegas должен наследоваться от класса Horse.
3. Класс SwimPegas должен наследоваться от класса Pegas.
4. Обьект класса Horse создать можно.
5. Обьект класса Pegas создать можно.
6. Метод swim() класса SwimPegas не должен иметь реализации.
*/

public class Solution {

    public static void main(String[] args) {
        Horse horse = new Pegas();
        horse.run();
    }

    // интерфейс плавания
    public interface Fly {
        void fly();
    }

    // асбстрактный класс родитель конь
    public static class Horse {
        // реализация метода абстактного класса
        public void run() {

        }
    }

    // наследник конея и интерфейса
    public static class Pegas extends Horse implements Fly {
        // реализация интерфейса
        public void fly() {

        }
    }

    // абстрактный класс, наследник пегаса
    public static abstract class SwimPegas extends Pegas {
        // абстрактный метод без реализации
        public abstract void swim();
    }

}
