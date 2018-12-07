package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/


public class Solution {
    public static void main(String[] args) throws IOException {
        // Программа должна использовать коллекции.
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        // Программа должна считывать одно значение с клавиатуры.
        // создаю объект для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
        // строка чтения символов, сразу перевожу в нижний регист все, не важно как там нАПисаННо
        String inputStr = reader.readLine().toLowerCase();

        // теперь новая строка, которая пишет месяц с большой буквы
        // отрезает от строки ввода 1й символ и переводит в верхний регистр
        // а затем добвляет кусок строки со 2го символа и до конца
        String month = inputStr.substring(0, 1).toUpperCase() + inputStr.substring(1);

        // переменная для номера месяца
        int monthNum = 0;

//        for (Map.Entry<String, Integer> pair : map.entrySet()) {
//            // сравнение строк
//            if (pair.getKey().equals(month)) {
//                // если нашли, то номеру месяца присваиваем значение из value
//                monthNum = pair.getValue();
//                // и прерываем цикл, смысл идти дальше по нему отсутствует
//                break;
//            }
//        }

        // тут перебор мэпа не нужен, достаточно просто обратиться по ключу
        // проверка если такой ключ не существует
        if (map.get(month) == null) {
            System.out.println("Ошибка ввода названия месяца");
            return;
        }
        // иначе по названию месяца вытаскиваю его value
        monthNum = map.get(month);

        // Программа должна выводить текст на экран.
        // форматированная строка
        System.out.printf("%s is the %d month", month, monthNum);
    }
}
