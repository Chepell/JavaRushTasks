package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити,
    чтобы обеспечить последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.

Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]


Требования:
1. Статический блок класса Solution должен считывать с консоли имена
    двух файлов и сохранять их в переменные firstFileName и secondFileName.
2. Объяви в классе Solution public static класс ReadFileThread.
3. Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
4. Класс ReadFileThread должен быть унаследован от подходящего класса.
5. Метод run класса ReadFileThread должен считывать строки из файла,
    установленного методом setFileName. А метод getFileContent, этого же класса,
    должен возвращать вычитанный контент. Возвращаемое значение - это одна строка,
    состоящая из строк файла, разделенных пробелами.
6. Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7. Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
 */

public class Solution {
    // публичные статичные переменные для именя файлов
    // объявляются самыми первыми в классе
    public static String firstFileName;
    public static String secondFileName;

    // статик-блок класса, выполнеяется сразу после объявления статичных переменных
    static {
        // создаю объект для чтения потока с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // оборачиваю ридеры в try-catch для отлова исключений
        try {
            // инициирую переменные через ридеры
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            // закрываю ридер
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // main метод исполняется третьим в классе
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    /// все остальные методы только создаются, исполняться могут только в теле main ///

    // статичный метод печати файла поданного в качестве параметра
    public static void systemOutPrintln(String fileName) throws InterruptedException {
        // создаю ссылочную переменную и указываю на вновь созданный объект
        ReadFileInterface f = new ReadFileThread();
        // используя метод класса назначаю имя файла
        f.setFileName(fileName);
        // запускаю нить
        f.start();
        // торможу все потоки, жду завершения текущей нити
        f.join();
        // обращаюсь к методу объекта и печатаю его
        System.out.println(f.getFileContent());
    }

    // интерфейс, который показывает все, что должно быть в классе
    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    // класс для чтения файла в потоке с реализацией интерфейса и наследник Thread
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        // поле для имени файла
        private String name;
        // список для чтения строк файла
        private List<String> list = new ArrayList<>();
        private String fullString = "";

        // реализация метода интерфейса инициализации поля
        @Override
        public void setFileName(String fullFileName) {
            name = fullFileName;
        }

        //
        @Override
        public void run() {
            // создаю объект класса файл
            // чтение из папки с проектом, беру поле имени, куда поданн адрес файла
            File file = new File(name);
            // переменная под строку файла
            String st;
//            try {
//                // создаю ридер для чтения файла
//                BufferedReader reader = new BufferedReader(new FileReader(file));
//                // цикл чтения срок продолжается, пока они есть
//                while ((st = reader.readLine()) != null) {
//                    // строка добавляется в список
//                    list.add(st);
//                }
//                // закрываю поток чтения
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            StringBuilder str = new StringBuilder();
            try {
                // создаю ридер для чтения файла
                BufferedReader reader = new BufferedReader(new FileReader(file));
                // цикл чтения срок продолжается, пока они есть
                while ((st = reader.readLine()) != null) {
                    // строка каждая строка добавляется в строковый буфер через пробел
                    str.append(st);
                    str.append(" ");
                }
                fullString = str.toString();
                // закрываю поток чтения
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        @Override
//        public String getFileContent() {0-
//            String string = "";
//            if (!list.isEmpty()) {
//                for (String str : list) {
//                    string = string + " " + str;
//                }
//            }
//            return string;
//        }

        @Override
        public String getFileContent() {
            return fullString;
        }
    }

}
