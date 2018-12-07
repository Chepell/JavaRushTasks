package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    // статичный метод принимает ENUM тип файла
    public static ImageReader getImageReader(ImageTypes type) {
        // И возвращает созданный объект подходящего класса
        // каждый класс реализует пустой интерфейс ImageReader
        if (type == ImageTypes.JPG) {
            return new JpgReader();
        } else if (type == ImageTypes.BMP) {
            return new BmpReader();
        } else if (type == ImageTypes.PNG) {
            return new PngReader();
        } else {
            // если введен какой-то иной тип, то кидаем исключение
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
