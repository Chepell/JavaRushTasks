package com.javarush.task.task36.task3608.dao.mock;

import com.javarush.task.task36.task3608.bean.User;

import java.util.LinkedList;
import java.util.List;

// класс симуляция БД в виде singleton
public class DataSource {
    // приватное статичное поле класса - singleton объект
    private static DataSource ourInstance = new DataSource();

    // статичный метод получения объекта
    public static DataSource getInstance() {
        return ourInstance;
    }

    // приватный конструктор что бы реализовать singleton и запретить создание других объектов
    private DataSource() {
    }

    // список из юзеров и сразу наполнение его данными, вот так интересно в двойных фигурных кавычках
    private List<User> users = new LinkedList<User>() {{
        add(new User("Ivanov", 123L, 1));
        add(new User("Petrov", 124L, 2));
        add(new User("Petrov", 125L, 1));
        add(new User("Sidorov", 126L, 2));
    }};

    // поле ограничение значения id
    private long maxUserId = 126L;

    // гетер получения поля users, списка объектов
    public List<User> getUsers() {
        return users;
    }

    // метод который проверяет есть ли такой юзер
    public User createOrUpdate(User newUser) {
        if (newUser == User.NULL_USER)
            return User.NULL_USER;

        //new User
        if (newUser.getId() == 0)
            return createNewUser(newUser);
        else
            return updateUser(newUser);
    }

    private User createNewUser(User newUser) {
        User clone = newUser.clone(++maxUserId);
        users.add(clone);
        return clone;
    }

    private User updateUser(User newUser) {
        for (User user : users) {
            if (user.getId() == newUser.getId()) {
                user.setName(newUser.getName());
                user.setLevel(newUser.getLevel());
                return user;
            }
        }
        //if we didn't find such a user
        return User.NULL_USER;
    }
}