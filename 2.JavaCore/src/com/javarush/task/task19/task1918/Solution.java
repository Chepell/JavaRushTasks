package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // объект для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // сохраняем имя файла в переменную
        String fileName = reader.readLine();
        // закрываю поток
        reader.close();

        // Параметр запуска программы сохраняю в переменную
        // это наш тег, который будем искать в файле
        String tag = args[0];

        // объект для сохранения строк из файла
        StringBuilder sb = new StringBuilder();

        // буффер чтения строк файла
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        // циклом читаю построчно
        while (readFile.ready()) {
            // строку сохраняю в переменную
            String line = readFile.readLine()
                    // удаляя если есть символ BOM и символ переноса строки
                    .replace("\uFEFF", "").replace("\n", "");
            // прочитанную и исправленную строку добавляю в строчный объект
            sb.append(line);
        }
        // файл прочитан, закрываю объект
        readFile.close();
        // конвертрую строчный объект в обычную строку
        String htmlString = sb.toString();

        // подаю в парсер строку html и сохраняю в ввиде объекта класса документ
        Document doc = Jsoup.parse(htmlString, "", Parser.xmlParser());
        // вытаскиваю массив определенных тэгов из документа
        Elements elements = doc.select(tag);

        // циклом прохожу по всем считанным тегам
        for (int i = 0; i < elements.size(); i++) {
            // печатаю каждый тег на экран
            System.out.println(elements.get(i));
        }
    }
}


//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        // объект для ввода имени файла с клавиатуры
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        // сохраняю имя файла в переменную
//        String fileName = reader.readLine();
//        // закрываю ридер
//        reader.close();
//
//        // создаю сортированный мэп в который сохраняю индекс начала
//        // паттерна и в value 0 если паттерн начала тэга и 1 если конца тэга
//        Map<Integer, Integer> map = new TreeMap<>();
//        // сохраняю имя тега введенного в качестве параметра программы
//        String arg = args[0];
//        // определяю длину тэга и добавляю еще 3 знака, </tag> что бы определить конец тега
//        int argLen = arg.length() + 3;
//
//        // создаю объект чтения файла
//        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
//        // объект для сохранения строк из файла
//        StringBuilder sb = new StringBuilder();
//
//        // циклом прохожу по файлу
//        while (readFile.ready()) {
//            // сохраняю в переменную считанную строку
//            String line = readFile.readLine()
//                    // удаляю если есть
//                    // BOM символ начала строки
//                    .replace("\uFEFF", "")
//                    // знак конца строки
//                    .replace("\n", "")
//                    // знак переноса каретки
//                    .replace("\r", "");
//            // итоговую строку добавляю в строчный объект
//            sb.append(line);
//        }
//        // файл прочитан, закрываю объект чтения
//        readFile.close();
//
//        // сохраняю объект файла в строку
//        String finalString = sb.toString();
//
//        // форматирую регулярку для тега открытия
//        String tagStart = "(<" + arg + "\\s|<" + arg + ">)";
//        // форматирую регулярку для тега закрытия
//        String tagEnd = "</" + arg + ">";
//        // создаю паттерны и матчеры для обоих типов тэга
//        Pattern patternStart = Pattern.compile(tagStart);
//        Matcher matcherStart = patternStart.matcher(finalString);
//        Pattern patternEnd = Pattern.compile(tagEnd);
//        Matcher matcherEnd = patternEnd.matcher(finalString);
//        // цилк поиска совпадений по матчеру начала тега
//        // пройдет по всей строке и добавит все совпадения
//
//        while (matcherStart.find()) {
//            // в меп добавляю пару, key индекс начала паттерна в строке,
//            // value всегда 0 что бы отличать от ситуаций закрытия
//            map.put(matcherStart.start(), 0);
//        }
//        // цикл поиска паттерна конца тега
//        // пройдет по всей строке и добавит все совпадения
//        while (matcherEnd.find()) {
//            // в меп добавляю пару, key индекс конца паттерна в строке,
//            // value всегда 0 что бы отличать от ситуаций закрытия
//            map.put(matcherEnd.start(), 1);
//        }
//
//        // цикл пока в мэпе есть записи
//        while (map.size() > 0) {
//            // создаю переменные
//            // счетчик
//            int count = 0;
//            // для сохранения индекса начала участка
//            int startInd = 0;
//            // для сохранения индекса конца участка
//            int endInd = 0;
//            // прохожу циклом по мэпу
//            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//                // если value 0, значит это
//                if (pair.getValue() == 0 && count == 0) {
//                    count++;
//                    startInd = pair.getKey();
//                    continue;
//                }
//                if (pair.getValue() == 0 && count != 0) {
//                    count++;
//                    continue;
//                }
//                if (pair.getValue() == 1 && count != 1) {
//                    count--;
//                    continue;
//                }
//                if (pair.getValue() == 1 && count == 1) {
//                    count--;
//                    endInd = pair.getKey();
//                    break;
//                }
//            }
//            System.out.println(finalString.substring(startInd, endInd + argLen));
//            map.remove(startInd);
//            map.remove(endInd);
//        }
//    }
//}