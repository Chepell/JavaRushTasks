package com.javarush.task.task16.task1607;

import java.util.ArrayList;
import java.util.List;

/* 
Horse Racing
Разберись, что делает программа.
Реализуй метод calculateHorsesFinished.
Он должен:
1. Посчитать количество финишировавших лошадей и возвратить его. Используй метод isFinished().
2. Если лошадь еще не пришла к финишу (!isFinished()), то:
2.1. Вывести в консоль "Waiting for " + horse.getName().
2.2. Подождать, пока она завершит гонку. Подумай, какой метод нужно использовать для этого.
2.3. Не считать такую лошадь финишировавшей.


Требования:
1. Метод calculateHorsesFinished должен вернуть количество финишировавших лошадей.
2. Метод calculateHorsesFinished должен вызывать метод isFinished у каждой лошади из переданного списка.
3. Если какая-либо из переданных в списке лошадей еще не финишировала,
    метод calculateHorsesFinished должен вывести в консоль "Waiting for " + horse.getName().
    Пример сообщения для первой лошади: "Waiting for Horse_01".
4. Если какая-либо из переданных в списке лошадей еще не финишировала,
    метод calculateHorsesFinished должен подождать пока она финиширует.
    Используй правильный метод для ожидания.
5. После завершения работы программы, консоль должна содержать информацию о том,
    что все лошади финишировали. Пример сообщения для первой лошади: "Horse_01 has finished the race!".
*/

public class Solution {
    // поле количеста лошедей на скачках
    public static int countHorses = 10;

    public static void main(String[] args) throws InterruptedException {
        // Объявление списка для хранения объектов типа Horse
        // иницириую список с помощю метода
        List<Horse> horses = prepareHorsesAndStart();

        // цикл вызывает метод в условии пока количество
        // лошадей пришедших на финиш и посчитанных с помощью этого метода
        // не равно заданному в поле countHorses количеству коней
        while (calculateHorsesFinished(horses) != countHorses) {
        }
        // вышли из цикла, занчит все кони пришли
//        System.out.println(calculateHorsesFinished(horses));

    }


    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int countFinished = 0;

        for (Horse horse: horses) {
            // если конкретная лошадь из списка финишировала
            // то итерирую счетчик лошадей достигших финиша
            if (horse.isFinished()) {
                countFinished++;
            } else {
                // иначе вывожу сообщение что жду финиша
                System.out.println("Waiting for " + horse.getName());
                // и торможу текущий поток, пока не будет завершен поток текущий лошади из цикла
                horse.join();
            }
        }
        return countFinished;
    }

    // метод возвращающий список объектов типа Horse
    public static List<Horse> prepareHorsesAndStart() {
        // создаю список, и сразу определяю длину списка с помошью статичного поля класса
        List<Horse> horses = new ArrayList<>(countHorses);
        // объявляю переменную под хранение номера лошади
        String number;
        for (int i = 1; i < countHorses + 1; i++) {
            // в тернарном операторе добавляю 0 перед числом если число из одного знака
            number = i < 10 ? ("0" + i) : ("" + i);
            // добавляю в список новый объект класса Horse
            // в конструкторе подаю имя по формату
            horses.add(new Horse("Horse_" + number));
        }
        // циклом запускаю все потоки у объектов
        for (int i = 0; i < countHorses; i++) {
            horses.get(i).start();
        }
        // и возвращаю список
        return horses;
    }

    // класс наследник от Thread
    public static class Horse extends Thread {
        // поле класса отвечающее за достижение финиша
        private boolean isFinished;

        // реалиазция конструктора
        public Horse(String name) {
            // передача значения в конструктор родительского класса
            super(name);
        }

        // метод возвращает состояние объекта
        public boolean isFinished() {
            return isFinished;
        }

        // переопределение метода нити
        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   //delay
                // конкатинация строки в цикле
                s += "" + i;
                // при достижении последней итерации
                if (i == 1000) {
                    // строка перезаписывается
                    s = " has finished the race!";
                    // и выводится сообщение о финише
                    System.out.println(getName() + s);
                    // и ставится соответствующая отметка, поле меняется на true
                    isFinished = true;
                }
            }
        }
    }
}
