package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

// это класс объекта, который будет хранить необходимые данные для отображения на клиенте
// класс будет запрашивать данные у модели
public class ModelData {
    // поле списка юзеров
    private List<User> users;
    // поле для манипуляций с конкретным пользователем
    private User activeUser;
    // флаг для определения эелементов
    private boolean displayDeletedUserList;

    // гетер и сетер для поля
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}