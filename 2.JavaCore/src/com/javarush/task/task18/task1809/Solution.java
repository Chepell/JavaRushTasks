package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName01 = reader.readLine();
        String fileName02 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName01);
        int size = inputStream.available();

        byte[] buffer = new byte[size];
        // читаю за раз все байты в буффер
        if (inputStream.available() > 0) {
            inputStream.read(buffer);
        }

//        // переменная для временного хранения элемента массива в момент замены
//        byte temp;
//        // циклом иду по массиву до середины и меняю местами элементы
//        for (int i = 0; i < buffer.length / 2; i++) {
//            temp = buffer[i];
//            buffer[i] = buffer[buffer.length - i - 1];
//            buffer[buffer.length - i - 1] = temp;
//        }
//
//        // поток записи
//        FileOutputStream outputStream = new FileOutputStream(fileName02);
//        outputStream.write(buffer);


        // Так проще, не разворачивая массив просто читаю его циклом в обратном порядке
        // поток записи
        FileOutputStream outputStream = new FileOutputStream(fileName02);
        for (int i = buffer.length - 1; i >= 0 ; i--) {
            // и пишу побайтово
            outputStream.write(buffer[i]);
        }

        inputStream.close();
        outputStream.close();


    }
}
