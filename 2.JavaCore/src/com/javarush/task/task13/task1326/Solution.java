package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // буффер для считывания имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // введеное имя файла сохраняю в строку
        String fileName = reader.readLine();

        // объект файлового потока
        FileInputStream fis = new FileInputStream(fileName);
        // буффер чтения из файла
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis));

        // лист для сохранения считанных строк
        List<Integer> evenNumList = new ArrayList<>();

        // читаю строку из файла
        String line = fileReader.readLine();

        // и вхожу в цикл, если строка прочиталась
        while (line != null) {
            // парсю строку в число
            Integer num = Integer.parseInt(line);
            // если число четное, то добавляю его в список
            if (num % 2 == 0) {
                evenNumList.add(num);
            }
            // в конце круга цикла читаю новую строку,
            // и если она еще есть, то цикл повторяется
            line = fileReader.readLine();
        }

        // сортирую список
        Collections.sort(evenNumList);
        // вывожу список на печать
        for (Integer i : evenNumList) {
            System.out.println(i);
        }

        // закрываю всё
        reader.close();
        fis.close();
        fileReader.close();
    }
}
