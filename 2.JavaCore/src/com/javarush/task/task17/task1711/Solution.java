package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople,
    выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List.
2. Класс Solution должен содержать статический блок,
    в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей
    с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей
    с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей
    с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные
    о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        switch (args[0]) {
            case "-c":
                // блок синхронизации по объекту
                // если объект занят, то не заходим
                synchronized (allPeople) {
                    createPersons(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updatePerson(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deletePerson(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    showPerson(args);
                }
                break;
//            default:
//                System.out.println("Что-то не так с ключем аргументов");
//                break;
        }
    }

    public static void createPersons(String[] args) {
        // массив преоразую в список
        List<String> onlyArgs = new ArrayList<>(Arrays.asList(args));
        // удаляю из списка первый ключ, оставляю только параметры
        onlyArgs.remove(0);

        // циклом прохожу по списку аргументов, но знаю что их 3 на элемент
        // поэтому итерирю через каждые 3 элемента
        for (int i = 0; i < onlyArgs.size(); i += 3) {
            // нулевой элмент, потом 3, потом 6
            String name = onlyArgs.get(i + 0);
            // первый элемент, потом 4, потом 7
            char sex = onlyArgs.get(i + 1).charAt(0);
            Date birthday = new Date();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                // второй элемент, потом 5, потом 8
                birthday = formatter.parse(onlyArgs.get(i + 2));
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
    }


    public static void updatePerson(String[] args) {
        // массив преоразую в список
        List<String> onlyArgs = new ArrayList<>(Arrays.asList(args));
        // удаляю из списка первый ключ, оставляю только параметры
        onlyArgs.remove(0);

        // циклом прохожу по списку аргументов, но знаю что их 4 на элемент
        // поэтому итерирю через каждые 4 элемента
        for (int i = 0; i < onlyArgs.size(); i += 4) {
            // парсю индекс человека в списке из строки
            int id = Integer.parseInt(onlyArgs.get(i + 0));
            String name = onlyArgs.get(i + 1);
            Sex sex = onlyArgs.get(i + 2).charAt(0) == 'м' ? Sex.MALE : Sex.FEMALE;
            Date birthday = new Date();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                birthday = formatter.parse(onlyArgs.get(i + 3));
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
    }

    public static void deletePerson(String[] args) {
        // массив преоразую в список
        List<String> onlyArgs = new ArrayList<>(Arrays.asList(args));
        // удаляю из списка первый ключ, оставляю только параметры
        onlyArgs.remove(0);

        // циклом прохожу по списку аргументов, и знаю что их 1 на элемент
        // поэтому итерирю через каждый элемент
        for (int i = 0; i < onlyArgs.size(); i++) {
            // парсю индекс человека в списке из строки
            int id = Integer.parseInt(onlyArgs.get(i));
            // Достаю человека из списка по индексу
            // создаю переменную и ссылаюсь на этого человека
            Person persToNull = allPeople.get(id);
            // используя сеттеры меняю человеку данные
            persToNull.setName(null);
            persToNull.setSex(null);
            persToNull.setBirthDay(null);
        }
    }

    public static void showPerson(String[] args) {
        // массив преоразую в список
        List<String> onlyArgs = new ArrayList<>(Arrays.asList(args));
        // удаляю из списка первый ключ, оставляю только параметры
        onlyArgs.remove(0);

        // циклом прохожу по списку аргументов, и знаю что их 1 на элемент
        // поэтому итерирю через каждый элемент
        for (int i = 0; i < onlyArgs.size(); i++) {
            // парсю индекс человека в списке из строки
            int id = Integer.parseInt(onlyArgs.get(i));
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
}