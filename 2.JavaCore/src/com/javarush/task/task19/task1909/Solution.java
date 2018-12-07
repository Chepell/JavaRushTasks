package com.javarush.task.task19.task1909;

/* 
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла
    (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла,
    где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // ридер для чтения имен файлов с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // сохраняю именя файлов в переменные
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
        // закрываю буффер
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        // переменная для чтения из файла строки
        String stringLine;
        // циклом иду по файлу
        while (bufferedReader.ready()) {
            // читаю в переменную строку
            stringLine = bufferedReader.readLine();
            // если в строке есть BOM, то удаляю его
            if (stringLine.startsWith("\uFEFF")) stringLine = stringLine.substring(1);
            // ищу и меняю в строке все точки на !
            stringLine = stringLine.replaceAll("\\.", "!");
            // пишу итоговую строку в файл
            bufferedWriter.write(stringLine);
            // и не забываю добавить новую строку т.к. читаю построчно исходный файл
            bufferedWriter.newLine();
        }
        // все строки файла прочитаны и записаны, закрываю объекты
        bufferedReader.close();
        bufferedWriter.close();
    }
}
