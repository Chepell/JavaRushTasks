package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка - конец ввода данных.
Числа могут повторяться.
Строки всегда уникальны.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.
Каждую пару с новой строки.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. В методе main объяви переменную коллекции HashMap и сразу проинициализируй ee.
4. Программа должна помещать в HashMap пары считанные с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap согласно условию.
Ключ и значение разделены пробелом. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // объявляю и инициирую объект для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // объявляю и инициирую меп для храниния пар, name будет ключем, а id значением
        HashMap<String, Integer> map = new HashMap<>();

        // вечный цикл ввода пар ключ:значение
        while (true) {
            int id;
            String name;

            // отлавливаю исключение, когда вместо числа введена строка
            try {
                id = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                // словил исключение, прерываю цикл
                break;
            }
            name = reader.readLine();
            map.put(name, id);
        }

        // цикл вывода пар значений на экран
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
