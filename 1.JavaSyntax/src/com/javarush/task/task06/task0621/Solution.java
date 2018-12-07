package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String paName = reader.readLine();
        Cat catPa = new Cat(paName, null, catGrandpa);

        String maName = reader.readLine();
        Cat catMa = new Cat(maName, catGrandma, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMa, catPa);

        String doName = reader.readLine();
        Cat catDo = new Cat(doName, catMa, catPa);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catPa);
        System.out.println(catMa);
        System.out.println(catSon);
        System.out.println(catDo);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        // конструктор по умолчанию
        Cat(String name) {
            this.name = name;
        }

        // полный конструктор
        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        // метод печати имен объектов
        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother " + ", no father ";
            else if (mother == null)
                return "Cat name is " + name + ", no mother " + ", father is " + father.name;
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father ";
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }
}
