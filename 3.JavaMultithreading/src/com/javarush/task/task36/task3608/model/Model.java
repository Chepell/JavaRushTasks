package com.javarush.task.task36.task3608.model;

public interface Model {
    // методы интрефейса которые реализуются в объектах типа model
    // это методы взаимодействия с БД
    ModelData getModelData();

    void loadUsers();

    void loadUserById(long userId);

    void loadDeletedUsers();

    void changeUserData(String name, long id, int level);

    void deleteUserById(long userId);


}
