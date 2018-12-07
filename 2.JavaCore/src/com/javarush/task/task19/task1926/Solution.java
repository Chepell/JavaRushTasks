package com.javarush.task.task19.task1926;

/* 
Перевертыши
1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все символы из файла в обратном порядке.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю объект чтения имени файла с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // сохраняю считаное имя файла в переменную
        String fileName = reader.readLine();
        // закрываю поток
        reader.close();

        // создаю поток чтения из файла
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));

        // циклом читаю из файла строки
        while (readFile.ready()) {
            // создаю объект для строк
            StringBuilder sb = new StringBuilder();
            // читаю строку в переменную, удалюя если есть символ BOM
            String line = readFile.readLine().replace("\uFEFF", "");
            // добавляю строку в объект и делаю реверс
            sb.append(line).reverse();
            // вывожу объект на экран предварительно конвертировав в строку
            System.out.println(sb.toString());
        }
        // цикл чтения закончен, закрываю поток
        readFile.close();
    }
}
