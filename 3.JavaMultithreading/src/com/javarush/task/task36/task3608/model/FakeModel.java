package com.javarush.task.task36.task3608.model;


import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

// класс с реализацией интерфейса
public class FakeModel implements Model {
    // фактически это композиция
    // создаю объект другого класса и использую его
    private ModelData modelData = new ModelData();

    // реализация методов интерфейса

    // метод возвращает поле класса
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    // метод инициирует поле значениями
    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("A", 1, 1));
        users.add(new User("B", 2, 1));
        users.add(new User("C", 3, 2));
        modelData.setUsers(users);
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
