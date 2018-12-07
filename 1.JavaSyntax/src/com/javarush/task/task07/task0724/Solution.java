package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grPa1 = new Human("Vasiliy", true, 63);
        Human grPa2 = new Human("Alex", true, 60);
        Human grMa1 = new Human("Natalia", false, 63);
        Human grMa2 = new Human("Galina", false, 58);
        Human pa = new Human("Artem", true, 34, grPa1, grMa1);
        Human ma = new Human("Olga", false, 29, grPa2, grMa2);
        Human kid1 = new Human("Polina", false, 2, pa, ma);
        Human kid2 = new Human("Misha", true, 1, pa, ma);
        Human kid3 = new Human("Roman", true, 0, pa, ma);

        System.out.println(grPa1.toString());
        System.out.println(grPa2.toString());
        System.out.println(grMa1.toString());
        System.out.println(grMa2.toString());
        System.out.println(pa.toString());
        System.out.println(ma.toString());
        System.out.println(kid1.toString());
        System.out.println(kid2.toString());
        System.out.println(kid3.toString());
    }

    public static class Human {
        // Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        // Конструктор для тех у кого нет родителей
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        // Полный конструктор
        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        // Метод печати информации по объектам класса
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















