package com.javarush.task.task36.task3608.model.service;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

// интрефейс с методами, которыми должен обладать класс
public interface UserService {
    // удаление пользователя по id и метод возвращает его
    User deleteUser(long id);

    // создание или обновление пользователя
    User createOrUpdateUser(String name, long id, int level);

    // получение списка пользователей по имени
    List<User> getUsersByName(String name);

    // получение списка всех удаленных пользователей
    List<User> getAllDeletedUsers();

    // получение списка пользователей между заданными уровнями
    List<User> getUsersBetweenLevels(int fromLevel, int toLevel);

    // получение списка активных пользователей из всего списка
    List<User> filterOnlyActiveUsers(List<User> allUsers);

    // получение пользователя по id не удаляя его
    User getUsersById(long userId);
}