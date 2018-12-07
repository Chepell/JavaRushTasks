package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными
    параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные
    о человеке с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        // Create
        // 4 аргумента, нулевой -с, второй м или ж
        if (args.length == 4 && args[0].equals("-c") && (args[2].equals("м") || args[2].equals("ж"))) {
            createPerson(args[1], args[2], args[3]);
        }

        // Update
        // 5 аргументов, нулевой -u, третий м или ж
        if (args.length == 5 && args[0].equals("-u") && (args[3].equals("м") || args[3].equals("ж"))) {
            updatePerson(args[1], args[2], args[3], args[4]);
        }

        // Delete
        // 2 аргумента, нулевой -d
        if (args.length == 2 && args[0].equals("-d")) {
            deletePerson(args[1]);
        }

        // Show
        // 2 аргумента, нулевой -i
        if (args.length == 2 && args[0].equals("-i")) {
            showPerson(args[1]);
        }


    }


    public static void createPerson(String args1, String args2, String args3) {
        String name = args1;
        char sex = args2.charAt(0);
        Date birthday = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            birthday = formatter.parse(args3);
        } catch (ParseException e) {
            System.out.println("You input wrong data");
        }
        // добавляю человека в список
        if (sex == 'м') {
            allPeople.add(Person.createMale(name, birthday));
        } else if (sex == 'ж') {
            allPeople.add(Person.createFemale(name, birthday));
        }
        // вывожу индекс на экран
        int id = allPeople.size() - 1;
        System.out.println(id);

    }

    public static void updatePerson(String args1, String args2, String args3, String args4) {
        // парсю индекс человека в списке из строки
        int id = Integer.parseInt(args1);
        String name = args2;
        Sex sex = args3.charAt(0) == 'м' ? Sex.MALE : Sex.FEMALE;
        Date birthday = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            birthday = formatter.parse(args4);
        } catch (ParseException e) {
            System.out.println("You input wrong data");
        }
        // Достаю человека из списка по индексу
        // создаю переменную и ссылаюсь на этого человека
        Person persToChange = allPeople.get(id);
        // используя сеттеры меняю человеку данные
        persToChange.setName(name);
        persToChange.setSex(sex);
        persToChange.setBirthDay(birthday);
    }

//    public static void deletePerson(String args1) {
//        // парсю индекс человека в списке из строки
//        int id = Integer.parseInt(args1);
//        // Удаляю человека из списка по индексу
//        allPeople.remove(id);
//    }

    public static void deletePerson(String args1) {
        // парсю индекс человека в списке из строки
        int id = Integer.parseInt(args1);
        // Достаю человека из списка по индексу
        // создаю переменную и ссылаюсь на этого человека
        Person persToNull = allPeople.get(id);
        // используя сеттеры меняю человеку данные
        persToNull.setName(null);
        persToNull.setSex(null);
        persToNull.setBirthDay(null);
    }

    public static void showPerson(String args1) {
        // парсю индекс человека в списке из строки
        int id = Integer.parseInt(args1);
        // Достаю человека из списка по индексу
        // создаю переменную и ссылаюсь на этого человека
        Person persToShow = allPeople.get(id);
        // используя геттеры беру нужные данные по человеку
        String name = persToShow.getName();
        // беру пол в ENUM
        Sex sex = persToShow.getSex();
        // получаю пол в виже м или ж из ENUM c помощью тернарного оператора
        String sexStr = sex == Sex.MALE ? "м" : "ж";
        // Беру дату рождения в виде объекта Data
        Date birthday = persToShow.getBirthDay();
        // Делаю форматтер для конвертации в нужную строку
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        // Получаю из даты строку нужного формата
        String birthdayStr = formatter.format(birthday);

        // Вывожу данные по человеку на экран
        System.out.println(name + " " + sexStr + " " + birthdayStr);
    }
}
