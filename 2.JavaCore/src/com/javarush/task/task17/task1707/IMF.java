package com.javarush.task.task17.task1707;

/*
МВФ
Singleton паттерн - синхронизация в методе.
Класс IMF - это Международный Валютный Фонд.
Внутри метода getFund создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект.
 */

public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        // блок не позволяет нескольким потокам создавать объект
        synchronized (IMF.class) {
            // lazy-initialization
            // создание объекта, только по запросу
            if (imf == null) imf = new IMF();
        }
        return imf;
    }

    // делаю конструктор по умолчанию приватным
    private IMF() {
    }
}
