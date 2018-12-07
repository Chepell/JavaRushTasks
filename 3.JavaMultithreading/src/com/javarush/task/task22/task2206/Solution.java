package com.javarush.task.task22.task2206;

import java.time.LocalDateTime;
import java.util.Date;

/* 
Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.

Должен быть вывод аналогичный следующему:
05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)


Требования:
1. Метод getFormattedString должен быть публичным.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.
*/
public class Solution {
    public static void main(String[] args) {
        // для старый библиотек даты
//        Date date = new Date();
        // для новой библотеки даты
        LocalDateTime date = LocalDateTime.now();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        // должен быть вывод аналогичный следующему
        // 22:08:18 14:01:30
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
