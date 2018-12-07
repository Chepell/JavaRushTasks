package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла
    (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова
    из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName01 = args[0];
        String fileName02 = args[1];

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader readFile = new BufferedReader(new FileReader(fileName01));
        while (readFile.ready()) {
            // сохраняю считанную строку удаляя если есть лишний символ
            String line = readFile.readLine().replace("\uFEFF", "");
            // режу строку по пробелам и сохраняю в массив строк
            String[] words = line.split(" ");
            // циклом иду по массиву
            for (String word : words) {
//                if (word.matches("^(?=.*\\d)(?=.*[a-zA-Zа-яА-ЯёЁ])[a-zA-Zа-яА-ЯёЁ0-9]+$")) {
                // если строка соответствует паттерну
                if (word.matches(".*\\d+.*")) {
                    // то добавляю в объект и добавляю пробел
                    sb.append(word).append(" ");
                }
            }
        }
        // закрываю поток чтения
        readFile.close();

        // конвертирую в строку и обрезаю лишние проблелы по сторонам
        String finalStr = sb.toString().trim();

        // создаю объект для записи в файл
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName02));
        writeFile.write(finalStr);
        // закрываю поток записи
        writeFile.close();
    }
}
