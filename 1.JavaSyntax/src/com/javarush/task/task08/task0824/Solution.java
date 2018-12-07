package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

// Программа должна выводить текст на экран.
// Класс Human должен содержать четыре поля.
// Класс Human должен содержать один метод.
// Класс Solution должен содержать один метод.
// Программа должна создавать объекты и заполнять их так, чтобы получилось:
// два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human son1 = new Human("Миша", true, 1);
        Human son2 = new Human("Коля", true, 5);
        Human dot = new Human("Полина", false, 3);

        Human dad = new Human("Артем", true, 34);
        dad.children.add(son1);
        dad.children.add(son2);
        dad.children.add(dot);
//        dad.addChild(son1);
//        dad.addChild(son2);
//        dad.addChild(dot);

        Human mom = new Human("Ольга", false, 29);
        mom.children.add(son1);
        mom.children.add(son2);
        mom.children.add(dot);
//        mom.addChild(son1);
//        mom.addChild(son2);
//        mom.addChild(dot);

        Human gp1 = new Human("Вася", true, 65);
        gp1.children.add(dad);
//        gp1.addChild(dad);

        Human gp2 = new Human("Саша", true, 62);
        gp2.children.add(mom);
//        gp2.addChild(mom);

        Human gm1 = new Human("Наташа", false, 65);
        gm1.children.add(dad);
//        gm1.addChild(dad);

        Human gm2 = new Human("Галя", false, 59);
        gm2.children.add(mom);
//        gm2.addChild(mom);

        System.out.println(son1);
        System.out.println(son2);
        System.out.println(dot);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(gp1);
        System.out.println(gp2);
        System.out.println(gm1);
        System.out.println(gm2);
    }

    public static class Human {
        // поля класса
        String name;
        boolean sex;
        int age;
        // список для хранения детей
        ArrayList<Human> children;

        // конструктор без детей
        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            // список инициирую, но при создании объекта не заполняю
            // там пустота по умолчанию
            this.children = new ArrayList<>();
        }


//        // метод добавления детей
//        public void addChild(Human human) {
//            children.add(human);
//        }

        // переопределение базового метода вывода
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            // считаю количество элементов в списке детей
            int childCount = this.children.size();
            // если дети есть
            if (childCount > 0) {
                // начинаю с одного ребенка
                text += ", дети: " + this.children.get(0).name;
                // остальных добавляю в цикле
                for (int i = 1; i < childCount; i++) {
                    // сначала вытаскиваю ребенка из списка
                    Human child = this.children.get(i);
                    // затем вытаскиваю поле имя у ребенка
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
