package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю буффер чтения из строки
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считываю имя файла с консоли в переменную
        String fileName = reader.readLine();
        reader.close();

        // обект для записи строк
        StringBuffer sb = new StringBuffer();

        FileReader fileReader = new FileReader(fileName);

        while (fileReader.ready()) {
            // читаю символ и делаю явное приведение типов
            char data = (char) fileReader.read();
            // добавляю прочитанный символ в строковый объект
            sb.append(data);
        }
        // вышли из цикла, закрываю объект чтения файла
        fileReader.close();

        // конвертирую строковый объект в строку
        String fileStr = sb.toString();
        // режу строку в массив строк по любым символам отличным от букв и цифр и _
        String[] world = fileStr.split("[\\W]");

        // счетчик слов в файле
        int worldCount = 0;
        // циклом иду по элементам массива
        for (String str : world) {
            // если есть совпадения, то инкрементирую счетчик
            if (str.matches("world")) worldCount++;
        }

        System.out.println(worldCount);
    }
}
