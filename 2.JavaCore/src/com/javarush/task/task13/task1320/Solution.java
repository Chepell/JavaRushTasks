package com.javarush.task.task13.task1320;

/* 
Neo
1. Реализовать интерфейс DBObject в классе User.
2. Реализовать метод initializeIdAndName так, чтобы программа работала и выводила на экран "User has name Neo, id = 1".
3. Метод toString и метод main менять нельзя.
4. Подумай, что должен возвращать метод initializeIdAndName в классе User.


Требования:
1. Интерфейс DBObject должен быть реализован в классе User.
2. Метод initializeIdAndName должен возвращать корректный объект типа User, объект на котором производится вызов метода("этот" объект).
3. Метод initializeIdAndName должен устанавливать значения полей id и name согласно переданным ему параметрам.
4. Программа должна выводить на экран: "User has name Neo, id = 1"
5. Метод toString не менять.
6. Метод main не менять.
*/

import javax.jws.soap.SOAPBinding;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        // объекту интерфейса присваивается новый объект User
        // где вызовом метода заполняются поля и он же и возвращается
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public String toString() {
            return String.format("User has name %s, id = %d", name, id);
        }

        @Override
        // тут нужно возвращать объект типа User, а не типа интерфейса
        public User initializeIdAndName(long id, String name) {
            // заполняю поля объекта
            this.id = id;
            this.name = name;
            // вовзвращаю сам объект
            return this;
        }
    }
}
