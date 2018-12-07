package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю ридер для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // сохраняю в переменные имена файлов
        String fileName01 = reader.readLine();
        String fileName02 = reader.readLine();
        String fileName03 = reader.readLine();
        // сразу закрываю поток
        reader.close();

        // создаю поток чтения из файла
        FileInputStream inputStream = new FileInputStream(fileName01);
        // определяю количество байт в файле
        int totalByteInFile = inputStream.available();
        // делю количество байт на две части
        int byteToFile03 = totalByteInFile / 2;
        int byteToFile02 = totalByteInFile - byteToFile03;

        // массивы-буферы для чтения байт пачками из файла
        byte[] bufferForFile02 = new byte[byteToFile02];
        byte[] bufferForFile03 = new byte[byteToFile03];

        // потоки для записи в файлы
        FileOutputStream outputStream02 = new FileOutputStream(fileName02);
        FileOutputStream outputStream03 = new FileOutputStream(fileName03);

        // если в потоке чтения есть байты
        if (inputStream.available() > 0) {
            // читай в буффер
            inputStream.read(bufferForFile02);
            // записываю буффер в файл
            outputStream02.write(bufferForFile02);
            inputStream.read(bufferForFile03);
            outputStream03.write(bufferForFile03);
        }

        inputStream.close();
        outputStream02.close();
        outputStream03.close();
    }
}
