package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла,
а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю буффер для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считываю с клавиатуры имена файлов
        String file01 = reader.readLine();
        String file02 = reader.readLine();
        String file03 = reader.readLine();
        // закрываю поток
        reader.close();

        // создаю файловые потоки
        FileOutputStream outputStream01 = new FileOutputStream(file01);
        FileInputStream inputStream02 = new FileInputStream(file02);
        FileInputStream inputStream03 = new FileInputStream(file03);

        // общий буффер для чтения из файлов блоками по 64 Кбайт
        byte[] buff = new byte[65536];

        // чтение из 2го файла в буффер и сразу запись в 1й файл
        while (inputStream02.available() > 0) {
            int count = inputStream02.read(buff);
            outputStream01.write(buff, 0, count);
        }

        // чтение из 3го файла в буффер и сразу запись в 1й файл
        while (inputStream03.available() > 0) {
            int count = inputStream03.read(buff);
            outputStream01.write(buff, 0, count);
        }

        // закрытие потоков
        outputStream01.close();
        inputStream02.close();
        inputStream03.close();
    }
}
