package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
Исправить функциональность в соответствии с требованиями.

Программа должна:
1. Переписать все байты одного файла в другой одним куском.
2. Закрывать потоки ввода-вывода.

Подсказка:
4 ошибки.


Требования:
1. Программа должна использовать классы FileInputStream и FileOutputStream.
2. Программа должна переписать все байты одного файла в другой одним куском.
3. Потоки FileInputStream и FileOutputStream должны быть закрыты.
4. Нужно исправить 4 ошибки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("e:/result.txt");

        // просто if, цикл не нужен т.к. читаю все за раз
        if (inputStream.available() > 0) {
            // создаю массив под чтение всех байт с размером равным количеству доступных байт
            byte[] buffer = new byte[inputStream.available()];
            // читаю байты в buffer и сохраняю сколько байт было прочитано в count
            int count = inputStream.read(buffer);
            // пишу байты из buffer в поток вывода в количестве count
            outputStream.write(buffer, 0, count);
        }
        // закрываю потоки
        inputStream.close();
        outputStream.close();
    }
}
