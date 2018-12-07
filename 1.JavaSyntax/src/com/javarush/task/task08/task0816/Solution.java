package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него
десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь
HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять
из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<>();
        map.put("Olga", df.parse("Jul 29 1980"));
        map.put("Artem", df.parse("Aug 3 1980"));
        map.put("Dima", df.parse("Apr 24 1980"));
        map.put("Viktor", df.parse("Sep 3 1980"));
        map.put("Polina", df.parse("Dec 14 1980"));
        map.put("Alex", df.parse("Dec 31 1980"));
        map.put("Mama", df.parse("Oct 1 1980"));
        map.put("Papa", df.parse("Nov 26 1980"));
        map.put("Galina", df.parse("Feb 7 1980"));
        map.put("Stallone", df.parse("Jun 1 1980"));

        return map;
    }

    // Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        // создаю мэп и копирую туда исходный, он нужен для итерации по элементам
        HashMap<String, Date> copy = new HashMap<>(map);

        // итерирую по копии мэпа
        for (Map.Entry<String, Date> pair : copy.entrySet()) {
            // Беру значение и т.к. это дата вытаскиваю оттуда месяц в виде числа
            // в старом классе Date нумерация месяцев с 0, поэтому добавляю +1
            int month = pair.getValue().getMonth() + 1;

            // Проверяю что месяц летний
            if (month > 5 && month < 9) {
                // удаляю элемент по текущему ключу
                map.remove(pair.getKey());
            }
        }
    }

    public static void printMap(HashMap<String, Date> map) {
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            int month = pair.getValue().getMonth() + 1;
            System.out.println(pair.getKey() + " : " + month);
        }
    }


    public static void main(String[] args) throws ParseException {

        HashMap map = createMap();
        removeAllSummerPeople(map);
        //printMap(map);

    }
}

//package com.javarush.task.task08.task0816;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
///*
//Добрая Зинаида и летние каникулы
//*/
//
//// Программа не должна выводить текст на экран.
//// Программа не должна считывать значения с клавиатуры.
//public class Solution {
//
//
//    // Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
//    public static HashMap<String, LocalDate> createMap() {
//        Locale.setDefault(Locale.ENGLISH);
//
//        // объявление и инициализация переменной для хранения даты с указанием формата
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
//
//        // объявление и инициализация переменной со ссылкой на хешкарту
//        HashMap<String, LocalDate> map = new HashMap<>();
//
//        // добавление пар ключ/значение в хэшмеп
//
//        map.put("Olga", LocalDate.parse("Jul 29 1980", formatter));
//        map.put("Artem", LocalDate.parse("Aug 3 1980", formatter));
//        map.put("Dima", LocalDate.parse("Apr 24 1980", formatter));
//        map.put("Viktor", LocalDate.parse("Sep 3 1980", formatter));
//        map.put("Polina", LocalDate.parse("Dec 14 1980", formatter));
//        map.put("Alex", LocalDate.parse("Dec 31 1980", formatter));
//        map.put("Mama", LocalDate.parse("Oct 1 1980", formatter));
//        map.put("Papa", LocalDate.parse("Nov 26 1980", formatter));
//        map.put("Galina", LocalDate.parse("Feb 7 1980", formatter));
//        map.put("Stallone", LocalDate.parse("Jun 1 1980", formatter));
//
//        //напишите тут ваш код
//        return map;
//    }
//
//    // Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
//    public static void removeAllSummerPeople(HashMap<String, LocalDate> map) {
//        // мэп под копию начального мэпа
//        HashMap<String, LocalDate> copy = new HashMap<>(map);
//
//        for (Map.Entry<String, LocalDate> pair : copy.entrySet()) {
//            // Беру значение и т.к. это дата вытаскиваю оттуда месяц в виде числа
//            int month = pair.getValue().getMonthValue();
//
//            // Проверяю месяц либо меньше либо больше
//            if (month > 5 && month < 9) {
//                // копирую пару в новый мэп
//                map.remove(pair.getKey());
//            }
//        }
//    }
//
//    public static void printMap(HashMap<String, LocalDate> map) {
//        for (Map.Entry<String, LocalDate> pair : map.entrySet()) {
//            int month = pair.getValue().getMonthValue();
//            System.out.println(pair.getKey() + " : " + month);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        HashMap map = createMap();
//        printMap(map);
//
//        System.out.println();
//
//        removeAllSummerPeople(map);
//        printMap(map);
//
//    }
//}
