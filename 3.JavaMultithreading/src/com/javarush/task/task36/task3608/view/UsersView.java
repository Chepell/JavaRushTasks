package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
    controller.onOpenUserEditForm(id);
    }



    @Override
    public void refresh(ModelData modelData) {
        // смотря какой список выводится
        String msg = modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:";
        System.out.println(msg);
        List<User> users = modelData.getUsers();
        for (User user: users) {
            System.out.println("\t"+user);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
