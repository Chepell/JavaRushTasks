package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел,
из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю буффер для чтения имен файлов с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // созраняю имена файлов в переменные
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
//        String inputFile = "00.txt";
//        String outputFile = "000.txt";
        // закрываю ридер
        reader.close();

        // создаю поток чтения файла
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        // создаю буффер для чтения символов файла
//        char[] buffer = new char[1000];
        // создаю объект для сохранения строк
        StringBuilder sb = new StringBuilder();

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            sb.append(line);
        }
        bufferedReader.close();

        // конвертирую объект строк в обычную строку
        String string = sb.toString();
        // режу стоку на слова и помещаю в массив строк
        String[] words = string.split(" ");
        //Создаю объект записи в файл
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

//        System.out.println(Arrays.toString(words));

        // циклом иду по всем словам массива
        for (String word : words) {
            // проверяю нет ли в начале строки этого гребанного символа
            // BOM (byte order mark, метка порядка байтов).
            // Это несуществующий символ, используемый для того,
            // чтобы отличать различные представления unicode.
            // если есть, то подрезаю строку
            if (word.startsWith("\uFEFF")) word = word.substring(1);
            //ищу цифры
            if (word.matches("\\d+")) {
                // если в строке только цифры то пишу их в файл и добавляю пробел
                bufferedWriter.write(word + " ");
            }
        }
        // прошел по всем элементам массива, значит запись закончена, закрываю объект записи
        bufferedWriter.close();
    }
}
