package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла
    (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все
    слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file01 = args[0];
        String file02 = args[1];

        BufferedReader readFile = new BufferedReader(new FileReader(file01));

        // т.к. знаю что в файле слова в одной строке, то читаю просто строку без цикла
        // сразу проверяю BOM символ, удаляю и режу строку по пробелам и помещаю в массив строк

        String[] words;
        StringBuffer sb = new StringBuffer();

        while (readFile.ready()) {
            String line = readFile.readLine().replace("\uFEFF", "");
            words = line.split(" ");
            // циклом иду по массиву слов
            for (int i = 0; i < words.length; i++) {
                // длина слова
                int wordLen = words[i].length();
                // если слово длинее 6 символов
                if (wordLen > 6) {
                    // то печатаю в файл
                    sb.append(words[i] + ",");
                }
            }
        }
        readFile.close();
        String finalString = sb.delete(sb.length() - 1, sb.length()).toString();

        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file02));
        writeFile.write(finalString);
        writeFile.close();
    }
}
