package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
    и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new FileInputStream("FIO.txt")));
        Person human = adapter.read();
        System.out.println(human);
    }

    // это класс-адаптер с интерфейсом к которому надо адаптировать
    public static class PersonScannerAdapter implements PersonScanner {
        // поле того что надо адаптировать
        // сканер создается один
        private final Scanner fileScanner;

        // конструктор сканера
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        // реализация методов интерфейса путем адоптации Scanner
        @Override
        public Person read() throws IOException {
            // создаю переменную в которую читаю сроку из файла
            String readPerson = "";
            if (fileScanner.hasNextLine()) {
                readPerson = fileScanner.nextLine();
            }
            // режу строку по пробелам и помещаю в массив строк
            String[] arrPerson = readPerson.split(" ");
            // значения складываю в переменные
            String firstName = arrPerson[1];
            String middleName = arrPerson[2];
            String lastName = arrPerson[0];

            // строка даты
            String date = arrPerson[3] + arrPerson[4] + arrPerson[5];
            // создаю объект даты
            Date birthday = null;
            try {
                // парсю строку даты в объект
                birthday = new SimpleDateFormat("ddMMyyyy").parse(date);
            } catch (ParseException e) {
            }
            // создаю и возвращаю объект класса Person
            return new Person(firstName, middleName, lastName, birthday);
        }

        @Override
        public void close() throws IOException {
            // метод вызывает анналогичный метод сканера
            fileScanner.close();
        }
    }
}
