package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData; // поле класса в виде интерфейса

    public Solution(String pathToFile) {
        // инициирую в конструкторе объект
        try {
            Path path = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path),
                    Files.isExecutable(path),
                    Files.isDirectory(path),
                    Files.isWritable(path));
        } catch (Exception e) {
            // если путь не существует, отлавливаю исключение и уже в catch блоке инициирую объект спецклассом
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
