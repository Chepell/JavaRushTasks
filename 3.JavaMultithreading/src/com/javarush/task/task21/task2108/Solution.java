package com.javarush.task.task21.task2108;

import java.util.Arrays;
import java.util.Objects;

/*
Клонирование растений
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.


Требования:
1. Класс Plant не должен поддерживать интерфейс Cloneable.
2. Класс Tree должен поддерживать интерфейс Cloneable.
3. Класс Tree должен быть потомком класса Plant.
4. В классе Tree должен быть корректно реализован метод clone.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);


        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    // класс растения
    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Plant plant = (Plant) o;
            return Objects.equals(name, plant.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Plant{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    // класс дерево, неследник расстения
    public static class Tree extends Plant implements Cloneable {
        // поле объекта это массив строк
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() throws CloneNotSupportedException {

//            // глубокое копирование масиива
//            // создаю массив строк с длиной равное массиву клонируемого обхекта
//            String[] cloneBranches = new String[this.branches.length];
//            // циклом иду по массиву и коприрую элементы
//            for (int i = 0; i < this.branches.length; i++) {
//                cloneBranches[i] = this.branches[i];
//            }

//            // достаточно вызвать метод, он делает deep copy
//            String[] cloneBranches = Arrays.copyOf(this.branches, this.branches.length);
//            Tree cloneTree = new Tree(this.getName(), cloneBranches);

            // а еще проше сделать так
            // т.к. в классе имплементирован интерфейс-маркер Cloneable
            // то вызываю метод
            Tree cloneTree = (Tree) super.clone();
            // и для массива строк clone тоже переопределен, поэтому можно так для deep copy
            cloneTree.branches = this.branches.clone();

            return cloneTree;
        }

        @Override
        public String toString() {
            return super.toString() + Arrays.toString(this.getBranches());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tree tree = (Tree) o;
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}
