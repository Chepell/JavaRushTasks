package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.bean.User;

// финальный класс с утилитами для работы
public final class Util {
    // строка добавляется к имени в User
    public static final String DELETED_MARKER = " (deleted)";

    // булевой метод проверки помечен ли объект как удаленный
    public static boolean isUserDeleted(User user) {
        return user.getName().endsWith(DELETED_MARKER);
    }

    // метод помечает объект как удаленный
    public static void markDeleted(User user) {
        // это не нулевой объект и еще не помечен как удаленный, тогда пометить
        if (User.NULL_USER != user && !Util.isUserDeleted(user)) {
            user.setName(user.getName() + DELETED_MARKER);
        }
    }
}