package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла,
которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим


Требования:
1. Класс Solution должен содержать публичное статическое
    поле words типа List, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в
    котором добавляются три или больше слов в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла,
    которые содержат всего 2 слова из списка words.
*/

public class Solution {
    // сразу при загрузке класса объявляется и инициируется список
    public static List<String> words = new ArrayList<>();

    // далее в статичном блоке добавляются записи в список
    static {
        words.add("файл"); //А
        words.add("вид"); //Б
        words.add("В"); //В
    }

    public static void main(String[] args) throws IOException {
        // объект чтения имения файла с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // сохраняю имя файла в переменную
        String fileName = reader.readLine();
        // закрываю поток чтения
        reader.close();

        // открываю поток чтения из файла
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));


        String line;
        String[] splitWords;
        int counter;
        // цикл проходит по строкам
        while (readFile.ready()) {
            // в начале цикла счетчик устанавливаю в ноль
            counter = 0;
            // если в считанной строке есть символы BOM то удаляю
            line = readFile.readLine().replace("\uFEFF", "");
            // режу строку по пробелам в массив строк
            splitWords = line.split(" ");
            // иду циклом по массиву строк
            for (String str : splitWords) {
                // если слово содержится в списке, то инкрементирую счетчик
//                if (words.contains(str)) counter++;
                // или используя статичный метод
                counter += Collections.frequency(words, str);
            }
            // если насчитал 2 слова, то печатаю строку
            if (counter == 2) {
                System.out.println(line);
            }
        }
        // вышел из цикла, чтение файла закончилось, закрываю поток
        readFile.close();
    }
}
