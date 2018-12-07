package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        // паттерн для парсинга строки по группам
        Pattern pattern = Pattern.compile("^(.+)\\s(\\d{1,2})\\s(\\d{1,2})\\s(\\d{4})$");

        String line;
        String name;
        Date birthday;
        while (readFile.ready()) {
            // читаю строку из файла и если есть BOM сразу удаляю
            line = readFile.readLine().replace("\uFEFF", "");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                name = matcher.group(1);
                String date = matcher.group(2) + "/" + matcher.group(3) + "/" + matcher.group(4);
                try {
                    birthday = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                    PEOPLE.add(new Person(name, birthday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        readFile.close();
    }
}
