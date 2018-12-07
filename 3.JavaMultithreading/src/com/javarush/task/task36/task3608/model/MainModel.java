package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

// сам класс модели реализующий соответствующий интерфейс
public class MainModel implements Model {
    // фактически это композиция
    // создаю объект другого класса и использую его
    // тут будут храниться данные взятые из БД для отображения
    private ModelData modelData = new ModelData();
    // и по композиции объект класса где фактически реализованы все методы работы с БД
    private UserService userService = new UserServiceImpl();

    private List<User> getAllUsers() {
        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(usersBetweenLevels);
    }

    // метод возвращает поле класса
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
//        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        // сетер наполняет поле объекта класса списком
        modelData.setUsers(getAllUsers());
        // устанавливаем флаг в нужное положение
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long userId) {
        User user = userService.deleteUser(userId);
        modelData.setUsers(getAllUsers());

    }

//    В классе MainModel в методе changeUserData(String, long, int) ты не вызвал
//    метод createOrUpdateUser у объекта класса UserService.
//В классе MainModel в методе changeUserData(String, long, int)
//    ты не установил список всех активных пользователей объекту modelData.

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        List<User> deletedUsers = userService.getAllDeletedUsers();
        // сетер наполняет поле объекта класса списком
        modelData.setUsers(deletedUsers);
        // устанавливаем флаг в нужное положение
        modelData.setDisplayDeletedUserList(true);
    }

}
