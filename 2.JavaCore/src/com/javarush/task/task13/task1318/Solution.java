package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        // напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//
//        // создаю поток чтения в программу из файла
//        InputStream in = new FileInputStream(fileName);
//
//        // пока поток не кончился читаю в цикле
//        while (in.available() > 0) {
//            // читаю в файл побайтово
//            int data = in.read();
//            // вывожу каждый байт на экран
//            // нужно использовать метод write для вывода на экран
//            System.out.write(data);
//        }
//
//        // в конце закрываю потоки
//        in.close();
//        reader.close();


        // создаю объект класса файл
        // чтение из папки с проектом
        File file = new File("01.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }

        br.close();
    }
}