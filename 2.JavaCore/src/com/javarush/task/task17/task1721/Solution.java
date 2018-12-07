package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines,
    то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List.
2. Класс Solution должен содержать public static поле forRemoveLines типа List.
3. Класс Solution должен содержать public void метод joinData()
    который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines,
    если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException,
    если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    // объявление и инициализация списков для чтения из файлов
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();


    public static void main(String[] args) {
        // Строки под чтение имен файлов
        String fileStr01 = "";
        String fileStr02 = "";

        // Оборачиваю в try-catch буффер чтения из потока
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileStr01 = reader.readLine();
            fileStr02 = reader.readLine();
            // закрываю буффер, он дальше не нужен
            reader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // создаю объекты файлов
        File file01 = new File(fileStr01);
        File file02 = new File(fileStr02);

        // оборачиваю в try-catch циклы чтения из файлов
        try {
            // буффер чтения из первого файла
            BufferedReader br01 = new BufferedReader(new FileReader(file01));
            // метод переносит все строки файла в список
            allLines = br01.lines().collect(Collectors.toList());

            // и из второго файла
            BufferedReader br02 = new BufferedReader(new FileReader(file02));
            // метод переносит все строки файла в список
            forRemoveLines = br02.lines().collect(Collectors.toList());

            // закрываю потоки
            br01.close();
            br02.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // вызываю метод с обработкой исключений в методе main
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }


    public void joinData() throws CorruptedDataException {
        // намного проще, чем что я ниже реализовал
        // проверяю что все элементы списка forRemoveLines содержатся в allLines
        if (allLines.containsAll(forRemoveLines)) {
            // тогда удаляю все эти элементы
            allLines.removeAll(forRemoveLines);
        } else {
            // иначе отчищаю список и выбрасываю исключение
            allLines.clear();
            throw new CorruptedDataException();
        }

//        int firstSize = allLines.size();
//        // удаляю из первого списка все элементы которые есть во втором списке
//        allLines.removeAll(forRemoveLines);
//        int afterDelSize = allLines.size();
//        int secondSize = forRemoveLines.size();
//
//        // Если во втором списке есть элементы, которых не было в первом
//        // то выбрасываю исключение
//        if (firstSize != afterDelSize + secondSize) {
//            allLines.clear();
//            throw new CorruptedDataException();
//        }
    }
}
