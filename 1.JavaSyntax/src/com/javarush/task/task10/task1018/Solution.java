package com.javarush.task.task10.task1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Поправочки нужны
Задача: Программа демонстрирует работу HashMap:
вводит с клавиатуры набор пар (номер и строку),
помещает их в HashMap и выводит на экран содержимое HashMap.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Класс Solution должен содержать три переменные.
4. Программа должна помещать в HashMap 10 пар считанных с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap. Каждое значение с новой строки.
*/

public class Solution {
    // поля класса
    HashMap<Integer, String> map;
    static Integer index;
    static String name;

    // конструктор класса
    public Solution() {
        // обявление и инициализация мепа объекта
        this.map = new HashMap<>();
        //map.put(index, name);
    }

    public static void main(String[] args) throws IOException {
        // создание объекта класса
        Solution solution = new Solution();
        // обявление и инициализация объекта класса для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // цикл записи данных с клавиатуры в мэп
        for (int i = 0; i < 10; i++) {
            // ввод key цифры
            int index = Integer.parseInt(reader.readLine());
            // ввод value строки
            String name = reader.readLine();
            // добавление пары в объект
            solution.map.put(index, name);
        }

        // цикл печати пар ключ:значение из мэпа объекта
        // прямой досутуп к полю мэп объекта, а дальше метод entrySet() для итерирования в цикле for-each
        for (Map.Entry<Integer, String> pair : solution.map.entrySet()) {
            // получение пар значений
            index = pair.getKey();
            name = pair.getValue();
            System.out.println("Id=" + index + " Name=" + name);
        }
    }
}