package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Player and Dancer
1. Подумать, что делает программа.
2. Изменить метод haveRest так, чтобы он вызывал метод
- play, если person имеет тип Player.
- dance, если person имеет тип Dancer.


Требования:
1. Класс Player должен реализовывать интерфейс Person.
2. Класс Dancer должен реализовывать интерфейс Person.
3. Метод haveRest должен вызывать метод play, если переданный ему объект является игроком(Player).
4. Метод haveRest должен вызывать метод dance, если переданный ему объект является танцором(Dancer).
5. Метод main должен считывать данные с клавиатуры.
6. Метод main должен прекращать считывать данные с клавиатуры, если введенная строка равна "exit".
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;

        // цикл считывает строку с клавиатуры, пока не буде получена строка exit
        // в условии цикла каждый раз обновляется значение key
        // вводом с клавиатуры, потом сравнивается с exit и либо выходит, либо продолжает
        while (!(key = reader.readLine()).equals("exit")) {
            // объекты интерфейса Person создаются, только если получен один из ключей
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            } else {
                // если введен не тот аргумет, то ссылка обнуляется
                person = null;
            }
            // затем вызывается метод
            haveRest(person);
        }
    }

    public static void haveRest(Person person) {
        if (person instanceof Player) {
            ((Player) person).play();
        } else if (person instanceof Dancer) {
            ((Dancer) person).dance();
        }
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}
