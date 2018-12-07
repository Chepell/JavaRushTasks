package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    // константы длины полей из условия задачи
    private static final int lenID = 8;
    private static final int lenProductName = 30;
    private static final int lenPrice = 8;
    private static final int lenQuantity = 4;


    public static void main(String[] args) throws Exception {
        // количество параметров командной строки
        int argsLen = args.length;

        // Буффер для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = "CRUD.txt";
        String fileName = reader.readLine();
        // имя файла прочитано, закрываем буффер
        reader.close();

        // удаление записи
        if (argsLen == 2 && "-d".equals(args[0])) {
//            System.out.println("удаляю запись");
            deLete(args, fileName);
            // если нет параметров командной строки
        } else if (argsLen == 0) {
//            System.out.println("нет аргументов, выхожу");
            System.exit(0);
            // обновление записи в файле
        } else if ("-u".equals(args[0])) {
//            System.out.println("обновляю запись");
            upDate(args, fileName);
        }
    }


    // метод удаляет из файла запись по id полученном в виде аргумента
    public static void deLete(String[] args, String fileName) throws IOException {
        // получаю id из параметра командной строки
        String id = args[1];
        // открываю файловый поток чтения из файла
        File file = new File(fileName);
        BufferedReader readFile = new BufferedReader(new FileReader(file));
        // список для всех строк файла
        List<String> list = new ArrayList<>();
        // чтение файла построчно
        String str;
        while ((str = readFile.readLine()) != null) {
            // из строки вырезаю только ID, первые 8 символов
            String idStr = str.substring(0, lenID);
            // удаляю лишние пробелы по сторонам
            idStr = idStr.trim();
            // нужно удалить символ который в начале файла появляется почему-то
            if (idStr.startsWith("\uFEFF")) idStr = idStr.substring(1);
            // добавляю строки в список если у них не совпадают id
            if (!id.equals(idStr)) {
                list.add(str);
            }
        }
        // закрываю поток
        readFile.close();

        // создаю буффер для записи
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file));

        // циклом иду по листу
        for (int i = 0; i < list.size(); i++) {
            // каждый элемент пишу в виде строки в файл
            writeFile.write(list.get(i));
            // что бы на последней итерации на пустую строку не перепрыгнуло
            if (i == list.size() - 1) break;
            // после конца строки перехожу на новую строку
            writeFile.newLine();
        }
        writeFile.close();
    }

    // метод оновляет запись в строке
    public static void upDate(String[] args, String fileName) throws IOException {
        // общее количество параметров командной строки
        int argsLen = args.length;

        // создаю билдер срок
        StringBuilder sb = new StringBuilder();

        // id в первом параметре
        String id = args[1];

        // метод добавляет id в sb
        cutOrSpaceAdd(lenID, sb, id);

        // productName
        // заготовка строки под productName
        String productName = "";

        // циклом по параметра начиная со второго собираю имя
        for (int i = 2; i < argsLen - 2; i++) {
            productName = productName + args[i] + " ";
        }

        // подрезаю у получившегося имени лишний пробле справа, получившийся из-за цикла
        productName = productName.trim();

        // если введенная строка длинее, чем максимально допустимая
        cutOrSpaceAdd(lenProductName, sb, productName);

        // price в пердпоследнем аргументе
        String price = args[argsLen - 2];

        cutOrSpaceAdd(lenPrice, sb, price);

        // quantity в последнем аргументе
        String quantity = args[argsLen - 1];

        cutOrSpaceAdd(lenQuantity, sb, quantity);

        // конвертирую в строку для записи в файл
        String upDateStr = sb.toString();

        // создаю объект файла
        File file = new File(fileName);
        // буффер чтения файла
        BufferedReader readFile = new BufferedReader(new FileReader(file));
        // список для всех строк файла
        List<String> list = new ArrayList<>();
        // чтение файла построчно
        String str;
        while ((str = readFile.readLine()) != null) {
            // из строки вырезаю только ID, первые 8 символов
            String idStr = str.substring(0, lenID);
            // удаляю лишние пробелы по сторонам
            idStr = idStr.trim();
            // нужно удалить символ который в начале файла появляется почему-то
            if (idStr.startsWith("\uFEFF")) idStr = idStr.substring(1);
            // если id строки из файла совпадает с id из командной строки
            // то значит эту строку полностью нужно изменить
            // копирую в список сознанную строку
            if (idStr.equalsIgnoreCase(id)) {
                list.add(upDateStr);
            }
            // иначе копирую в список строку из файла
            if (!id.equals(idStr)) {
                list.add(str);
            }
        }
        // закрываю поток чтения
        readFile.close();

        // создаю буффер для записи
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file));

        // циклом иду по листу
        for (int i = 0; i < list.size(); i++) {
            // каждый элемент пишу в виде строки в файл
            writeFile.write(list.get(i));
            // что бы на последней итерации на пустую строку не перепрыгнуло
            if (i == list.size() - 1) break;
            // после конца строки перехожу на новую строку
            writeFile.newLine();
        }
        writeFile.close();
    }


    private static void cutOrSpaceAdd(int lenConst, StringBuilder sb, String arg) {
        int lenArgs = arg.length();
        if (lenArgs > lenConst) {
            // то подрезаю строку
            arg = arg.substring(0, lenConst);
            // и добавляю sb
            sb.append(arg);
        } else {
            // сначала добавляю в sb
            sb.append(arg);
            // определяю сколько пробелов нужно добавить после productName
            int countPNLen = lenConst - lenArgs;
            // циклом добавляю нужное количество пробелов
            for (int i = 0; i < countPNLen; i++) {
                sb.append(" ");
            }
        }
    }
}