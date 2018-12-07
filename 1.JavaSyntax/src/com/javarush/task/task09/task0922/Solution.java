package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран введенную дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Программа должна выводить данные на экран.
5. Вывод должен соответствовать заданию.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        // инициирую переменную буффера для ввода строки
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ввод строки в переменную
        String dateStr = reader.readLine();

        // переменная отвечает за форматирование даты на основе паттерна и локализации
        SimpleDateFormat stringToDataFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        // парсинг строки по формату и сохранение в переменную даты
        Date date = stringToDataFormat.parse(dateStr);

        // форма для вывода
        SimpleDateFormat dateToStringFofmat = new SimpleDateFormat("MMM dd, YYYY", Locale.US);

        // форматирую в строку и поднимаю регистр
        String finalData = dateToStringFofmat.format(date).toUpperCase();

        System.out.println(finalData);
    }
}
