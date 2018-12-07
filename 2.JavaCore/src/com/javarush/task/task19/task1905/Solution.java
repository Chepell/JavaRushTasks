package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс Solution должен содержать интерфейс RowItem.
4. Класс Solution должен содержать интерфейс Contact.
5. Класс Solution должен содержать интерфейс Customer.
6. Класс DataAdapter должен реализовывать интерфейс RowItem.
7. Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
8. Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact), который инициализирует поля contact и customer.
9. В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<>();
    // инициализация мэпа в статичном
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    // класс адаптер с интерфейсом который нужно адаптировать
    public static class DataAdapter implements RowItem {
        // поля к которым нужно адаптировать интфейс
        private Customer customer;
        private Contact contact;

        // в конструктор подается два интерфейса, к которым нужно адаптироваться
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        // реализация методов интерфейса которые нужно адаптировать
        @Override
        public String getCountryCode() {
            String country = customer.getCountryName();
            String countryCode = "";
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(country)) {
                    countryCode = pair.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String name = contact.getName();
            return name.replaceFirst("\\w+, ","");
        }

        @Override
        public String getContactLastName() {
            String name = contact.getName();
            return name.replaceFirst(", [a-zA-Z]+","");
        }

        @Override
        public String getDialString() {
            String tel = contact.getPhoneNumber();
            return "callto://" + tel.replaceAll("(\\(|\\)|-)", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}