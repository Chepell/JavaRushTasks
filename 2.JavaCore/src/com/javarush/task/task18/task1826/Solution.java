package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // расшифровать файл
        if ("-e".equals(args[0])) {
            deEnCoder(args[1], args[2]);
        }

        // зашифровать файл
        if ("-d".equals(args[0])) {
            deEnCoder(args[1], args[2]);
        }
    }

    public static void deEnCoder(String fileForCipher, String encryptedFile) throws IOException {
        // создаю потоки для чтения из файла и записи в другой файл
        FileInputStream inputStream = new FileInputStream(fileForCipher);
        FileOutputStream outputStream = new FileOutputStream(encryptedFile);

        // цикл побайтового чтения файла и записи в зашифрованный файл
        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            int chageByte;

            if (readByte == 0 || readByte == -128) {
                outputStream.write(readByte);
            } else {
                chageByte = readByte * -1;
                outputStream.write(chageByte);
            }
        }
        inputStream.close();
        outputStream.close();
    }

}
