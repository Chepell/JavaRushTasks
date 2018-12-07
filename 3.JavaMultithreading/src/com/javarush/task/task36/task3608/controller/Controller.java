package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

// Этот класс будет получать запрос от клиента, оповещать Модель об этом,
// а Модель, в свою очередь, будет обновлять ModelData.
public class Controller {
    // поля объектов, которыми контроллер будет управлять
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;


    // должен обратиться к модели и инициировать загрузку пользователей
    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    // загрузка объектов помеченных как удаленные
    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long userId) {
        model.deleteUserById(userId);
        usersView.refresh(model.getModelData());
    }

//    В методе onUserChange(String, long, int) ты не обновил объект класса UsersView.
//    Как параметр метода refresh нужно использовать model.getModelData().
    public void onUserChange(String name, long id, int level) {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }

    // сетеры для подключения models and views
    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }
}
