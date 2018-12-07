package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

// Класс Solution будет эмулятором пользователя
public class Solution {


    public static void main(String[] args) {
        // создаю объекты MVC
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        // передаю во вьювер объект контроллера
        usersView.setController(controller);
        // и во втрой вьевер
        editUserView.setController(controller);
        // а в контроллер объект модели
        controller.setModel(model);
        // и в контроллер объект вьювера
        controller.setUsersView(usersView);
        // и еще объект второго вьювера
        controller.setEditUserView(editUserView);
        // вызываю на вьювере метод вывода в консоль
        usersView.fireEventShowAllUsers();
        // метод выводит только удаленные объекты на экран
        // В методе main класса Solution необходимо вызвать метод открытия формы
        // редактирования для пользователя с id=126 у объекта класса UsersView
        // перед вызовом метода fireEventShowDeletedUsers().
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("NeIvanov", 123L, 22);
        usersView.fireEventShowDeletedUsers();

//        Вызов метода fireEventUserChanged(String, long, int) должен быть расположен
//        перед вызовом метода fireEventShowDeletedUsers().
    }
}