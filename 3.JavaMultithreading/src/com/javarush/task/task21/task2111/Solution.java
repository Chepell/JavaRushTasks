package com.javarush.task.task21.task2111;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/* 
Освобождаем ресурсы
Реализуй метод finalize, предварительно обдумав, что именно в нем должно быть.
Проведи рефакторинг метода getUsers в соответствии с java7 try-with-resources.


Требования:
1. Метод finalize в классе Solution должен содержать вызов super.finalize().
2. Метод finalize в классе Solution должен корректно завершаться в случае, если значение поля connection равно null.
3. Метод finalize в классе Solution должен закрывать текущее соединение, если значение поля connection не равно null.
4. Метод getUsers должен корректно использовать try-with-resources.
*/
public class Solution {
    // приватное поле класса конекшн
    private Connection connection;

    // публичный конструктор, который принимает конкшн и инициирует поле класса
    public Solution(Connection connection) {
        this.connection = connection;
    }

    // переопределение метода для закрытия потока Connection
    @Override
    protected void finalize() throws Throwable {
        try {
            // если поток открыт, то закрываю его
            if (connection != null) {
                connection.close();
            }
        } finally {
            // и в любом случае вконце вызываю метод суперкласса
            super.finalize();
        }
    }

    // публичный метод, геттер, возвращающий список пользователей
    public List<User> getUsers() throws SQLException {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
            return result;
        }
    }

    // статичный класс
    public static class User {
        // приватные поля класса
        private int id;
        private String name;
        private int level;
        private int lesson;

        // полный конструктор класса
        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        // переопределение метода класса, для вывода всех полей объекта
        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }

    public static void main(String[] args) {

    }


}
