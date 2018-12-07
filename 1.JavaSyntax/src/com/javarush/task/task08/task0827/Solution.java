package com.javarush.task.task08.task0827;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/* 
Работа с датой
*/

// Программа должна выводить текст на экран.
// Класс Solution должен содержать два метода.
public class Solution {
    public static void main(String[] args) {
        // Метод main() должен вызывать метод isDateOdd().
        //System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("june 2 2013"));
    }


    // Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
    public static boolean isDateOdd(String date) {
        // Создаю объект класса для преобразования строки в объект класса времяДата
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive() // метод делает так, что строка становится нечувствительна к регистру
                .appendPattern("MMMM d yyyy") // паттерн парсинга, 4M что бы вводить целые имена месяцев
                .toFormatter() // отправить в форматтер
                .withLocale(Locale.US); // взять американские правила

        // Строку записываю в переменную времени, парсинг идет исходя из паттерна форматирования
        LocalDate nowDate = LocalDate.parse(date, formatter);

        int days = nowDate.getDayOfYear();

        if (days % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

/////// НА ОСНОВЕ СТАРЫХ БИБЛИОТЕК ДАТЫ //////
//    // Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
//    public static boolean isDateOdd(String date) throws ParseException {
//        // объявляю переменную для формата даты
//        DateFormat df = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
//        // объявляю переменную даты, парсирую туда дату из архумента метода
//        Date dd = df.parse(date);
//        // создаю еще одну переменную даты для начала года
//        Date startYear = df.parse(date);
//        // меняю в переменной начала года месяц и день на нулевые
//        startYear.setDate(0);
//        startYear.setMonth(0);
//
//        // считаю разницу в мс между этими датами
//        long timeDiff = dd.getTime() - startYear.getTime();
//        // в переменной считаю сколько мс в сутках
//        long msDay = 24 * 60 * 60 * 1000;
//        // считаю количество дней между датами
//        int days = (int)(timeDiff / msDay);
//
//        if (days % 2 == 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
