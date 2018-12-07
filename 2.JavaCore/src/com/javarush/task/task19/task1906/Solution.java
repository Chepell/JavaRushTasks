package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным
порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // ридер для чтения имения файлов с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Считываю имена в переменные
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
        // закрываю ридер
        reader.close();

        // создаю потоки чтения/записи файлов
        FileReader fileReader = new FileReader(inputFile);
        FileWriter fileWriter = new FileWriter(outputFile);

        int counter = 0;
        while (fileReader.ready()) {
            // читаем один символ в переменную
            int data = fileReader.read();
            counter++;
            // запись в файл если считан четный символ
            if (counter % 2 == 0) {
                fileWriter.write(data);
            }
        }

        // вышли из цикла, закрываем потоки
        fileReader.close();
        fileWriter.close();

    }
}
