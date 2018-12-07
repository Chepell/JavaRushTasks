package com.javarush.task.task16.task1608;

/* 
Продвижение на политических дебатах
1. Разберись, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал, пока не завершится всё свободное время.


Требования:
1. Вызови метод join у нужного объекта.
2. Метод toString класса политик Politician должен выводить сколько речей сказал политик, например: "Иванов сказал речь 35 раз".
3. Программа должна создавать 3 объекта типа Politician.
4. Методы, которые отвечают за вывод в консоль, не изменять.
5. Вывод программы должен свидетельствовать о том, что Иванов сказал больше всего речей на политических дебатах.
*/

public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        // Создание объектов и запуск нитей прямо из конструктора
        Politician ivanov = new Politician("Иванов");
        // метод тормозит главную нить, пока не
        ivanov.join();
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");

        // цикл пока общее число речей всех политиков меньше доступного по лимиту
        // т.е. позволяю им говорить пока не достигнут лимит
        while (ivanov.getCountSpeeches() + petrov.getCountSpeeches() + sidorov.getCountSpeeches() < totalCountSpeeches) {
        }

        // тогда выхожу из цикла и печатаю фактически метож toString
        // по каждому из объектов
        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }


    // класс политика наследуется от Thread
    public static class Politician extends Thread {
        // приватное поле, которое не должно кэшироваться в потоке
        // и будет меняться, поэтом отправить его в MainMemory
        private volatile int countSounds;

        // конструктор
        public Politician(String name) {
            // имя передается в конструктор родителя
            super(name);
            // и сразу в конструкторе запускается нить
            start();
        }

        // переопределение метода нити, который запускает start
        public void run() {
            // цикл проолжается если не превышен
            // общий хронометраж выступления для всех участников
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                // тогда фиксирую что сказал еще
                countSounds++;
            }
        }

        // сколько речей сказал конкретный политик
        public int getCountSpeeches() {
            return countSounds / soundsInOneSpeech;
        }

        // переопределение метода
        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeeches());
        }
    }
}

