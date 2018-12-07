package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            solution.users.put("Hubert", new User(11, "Hub"));
            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    // поле класса, мэп, просто так не склонируется полностью, только ссылка
    protected Map<String, User> users = new LinkedHashMap();

    // метод клонирования где нужно вручную копировать объект
    public Solution clone() throws CloneNotSupportedException {
        // создаю объект класса
        Solution cloneSol = new Solution();
        // создаю копию поля Map
        cloneSol.users = new LinkedHashMap();
        // циклом иду по мэпу текущего обхекта
        for (Map.Entry<String, User> pair : this.users.entrySet()) {
            // вытаскиваю пару ключ/значение
            // причем ключ, просто беру т.к. это примитив
            String key = pair.getKey();
            // а значение коприрую с помощью метода clone
            User value = (User) pair.getValue().clone();
            // помещаю в новый объект
            cloneSol.users.put(key, value);
        }
        // возвращаю склонированный объект
        return cloneSol;
    }

    // и нужно переопределять методы сравнения и хэша
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }


    // класс реализует интерфейс клонирования
    public static class User implements Cloneable {
        int age;
        String name;

        // конструктор класса
        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // переоределяю стандартный метод клонирования
        @Override
        protected Object clone() throws CloneNotSupportedException {
            // т.к. у класса в полях только примитивы, то
            // достаточно вызвать метод суперкласса и все будет нормально склонировано
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
