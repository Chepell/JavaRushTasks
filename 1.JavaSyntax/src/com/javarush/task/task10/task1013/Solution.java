package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        //private static int objectCount = 1;

        private String firstName;
        private String secondName;
        private int age;
        private boolean sex;
        private String address;
        private int id;


        public Human() {
//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, int age, boolean sex, String address) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.address = address;

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, int age, boolean sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = false;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.sex = false;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName) {
            this.firstName = firstName;
            this.secondName = "";
            this.age = 0;
            this.sex = false;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, boolean sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.sex = sex;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, boolean sex, String address) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.sex = sex;
            this.address = address;

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(int age, boolean sex) {
            this.firstName = "";
            this.secondName = "";
            this.age = age;
            this.sex = sex;
            this.address = "";

//            this.id = objectCount;
//            objectCount++;
        }

        public Human(String firstName, String secondName, String address) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.sex = false;
            this.address = address;

//            this.id = objectCount;
//            objectCount++;
        }

//        public static int getObjectCount() {
//            return objectCount;
//        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public int getAge() {
            return age;
        }

        public boolean isSex() {
            return sex;
        }

        public String getAddress() {
            return address;
        }

        public int getId() {
            return id;
        }
    }

}
