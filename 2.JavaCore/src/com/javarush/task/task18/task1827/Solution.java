package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла,
генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // количество параметров командной строки
        int argsLen = args.length;

        // константы длины полей из условия задачи
        final int lenID = 8;
        final int lenProductName = 30;
        final int lenPrice = 8;
        final int lenQuantity = 4;

        // Буффер для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = "CRUD.txt";
        String fileName = reader.readLine();
        // имя файла прочитано, закрываем буффер
        reader.close();

//        if (argsLen == 0) {
////            System.out.println("нет аргументов, выхожу");
//            System.exit(0);
//        } else

        if (argsLen > 0 && "-c".equals(args[0])) {
//            System.out.println("Создаю новую запись");
            creAte(args, fileName);
        }
    }


    // метод добавляет в конец файла новую запись полученную в виде аргумента
    public static void creAte(String[] args, String fileName) throws IOException {
        // общее количество параметров командной строки
        int argsLen = args.length;

        // открываю файл и поток для выяснения последнего id
        File file = new File(fileName);
        BufferedReader readFile = new BufferedReader(new FileReader(file));
        // переменная для последней строки
        String strLine = null;
        // переменная для итерирования, которая превратится в null на последнем цикле
        String tmp;
        while ((tmp = readFile.readLine()) != null) {
            // сохраняю последнюю прочитанную успешно строку
            strLine = tmp;
        }
        // закрываю поток
        readFile.close();

        // из строки вырезаю только ID, первые 8 символов
        String idStr = strLine.substring(0, 8);
        // удаляю лишние пробелы по сторонам
        idStr = idStr.trim();
        // нужно удалить символ который в начале файла появляется почему-то
        if (idStr.startsWith("\uFEFF")) idStr = idStr.substring(1);
        // парсю ID в число
        int intID = Integer.parseInt(idStr);
        // инкрементирую ID, получаю новое значение
        int idNew = intID + 1;

        // создаю билдер срок
        StringBuilder sb = new StringBuilder();

        // конвертирую новый ID в строку
        String newIdStr = idNew + "";

        // метод добавляет id в sb
        cutOrSpaceAdd(8, sb, newIdStr);

        // productName
        // заготовка строки под productName
        String productName = "";

        // циклом по параметра начиная c первого собираю имя
        for (int i = 1; i < argsLen - 2; i++) {
            productName = productName + args[i] + " ";
        }

        // подрезаю у получившегося имени лишний пробле справа, получившийся из-за цикла
        productName = productName.trim();

        // если введенная строка длинее, чем максимально допустимая
        cutOrSpaceAdd(30, sb, productName);

        // price в пердпоследнем аргументе
        String price = args[argsLen - 2];

        cutOrSpaceAdd(8, sb, price);

        // quantity в последнем аргументе
        String quantity = args[argsLen - 1];

        cutOrSpaceAdd(4, sb, quantity);

        // конвертирую в строку для записи в файл
        String outputStr = sb.toString();

        // создаю буффер записи с добавлением в конец файла
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        // метод переходит на новую строку
        bw.newLine();
        // пишем строку в файл
        bw.write(outputStr);
        // закрываем буффер
        bw.close();
    }


    private static void cutOrSpaceAdd(int lenConst, StringBuilder sb, String arg) {
        int lenArgs = arg.length();
        if (lenArgs > lenConst) {
            // то подрезаю строку
            arg = arg.substring(0, lenConst);
            // и добавляю sb
            sb.append(arg);
        } else if (lenArgs < lenConst) {
            // сначала добавляю в sb
            sb.append(arg);
            // определяю сколько пробелов нужно добавить после productName
            int countPNLen = lenConst - lenArgs;
            // циклом добавляю нужное количество пробелов
            for (int i = 0; i < countPNLen; i++) {
                sb.append(" ");
            }
        } else { // строка ровно в длину поля
            // просто добавляю в sb
            sb.append(arg);
        }
    }
}