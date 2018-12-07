package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и
    Contact используя подсказки в виде комментариев в интерфейсах.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            return "+" + data.getCountryPhoneCode() + String.format(
                    "%010d",
                    data.getPhoneNumber()
            ).replaceFirst(
                    "(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
                    "($1)$2-$3-$4"
            );
//            String phoneStr = data.getPhoneNumber() + "";
//            int phoneLen = phoneStr.length();
//            String last2 = phoneStr.substring(phoneLen - 2);
//            String preLast2 = phoneStr.substring(phoneLen - 4, phoneLen - 2);
//            String first3 = phoneStr.substring(phoneLen - 7, phoneLen - 4);
//            String first = phoneStr.substring(0, phoneLen - 7);
//            String add = "";
//            int needAdd = 10 - phoneLen;
//            if (needAdd > 0) {
//                for (int i = 0; i < needAdd; i++) {
//                    add += "0";
//                }
//            }
//            StringBuilder sb = new StringBuilder("+");
//            sb.append(data.getCountryPhoneCode());
//            sb.append("(").append(add).append(first).append(")");
//            sb.append(first3).append("-").append(preLast2).append("-").append(last2);
//            String number = sb.toString();
//            return number;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}