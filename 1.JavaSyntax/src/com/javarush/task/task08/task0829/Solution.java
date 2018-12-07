package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

//1. Программа должна выводить текст на экран.
//2. Программа должна считывать значения с клавиатуры.
//3. Класс Solution должен содержать один метод.
//4. Программа должна вывести фамилию семьи по введенному городу.

public class Solution {
    public static void main(String[] args) throws IOException {
        // объект класса чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // список адресов
        List<String> addresses = new ArrayList<>();

        // мэп значений
        Map<String, String> cities = new HashMap<>();

        // вечный цикл ввода строки
        while (true) {
            // читаю две строки с клавиатуры в переменные
            //System.out.println("Введите город:");
            String inputCity = reader.readLine();

            // если первая введенная строка пустая, то прерываю цикл
            if (inputCity.isEmpty()) break;

            //System.out.println("Введите фамилию:");
            String inputFamily = reader.readLine();


            // преобразую строки в нормальное написание
            String city = inputCity.substring(0, 1).toUpperCase() + inputCity.substring(1).toLowerCase();
            String family = inputFamily.substring(0, 1).toUpperCase() + inputFamily.substring(1).toLowerCase();

            // добавляю исправленные переменные как пару ключ:значение в мэп
            cities.put(city, family);
        }

        //System.out.println("Введите город для поиска");
        // ввожу город для поиска семьи
        String inputCity = reader.readLine().toLowerCase();
        // как бы не был введен город, переводу в написание с большой буквы, а остальные маленькие
        String cityName = inputCity.substring(0, 1).toUpperCase() + inputCity.substring(1).toLowerCase();

        // если введенная строка не пустая, то продолжаю
        if (!cityName.isEmpty()) {
            // и по номеру дома, фактически по индексу возвращаю фамилию
            String familyName = cities.get(cityName);

            // и вывожу ее на диван
            System.out.println(familyName);
        }
    }
}
