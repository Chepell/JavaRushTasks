package com.javarush.task.task24.task2407;

import com.sun.deploy.util.StringUtils;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     *
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */

    // обязательная реализация метода интрефейса Pet
    // в котором в свою очередь нужно реализовыать метод say()
    // для этого создается локальный класс реализующий интрфейс Sayable
    // а внутри него обязательная реализация метоа say()
    public Sayable toSayable(final int i) {
        class CatPet implements Sayable {
            @Override
            public String say() {
                String string = "";
                if (i < 1) {
                    string += name + " спит.";
                } else {
                    StringBuilder miau = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        miau.append("я");
                    }
                    string = String.format("%s говорит м%sу!", name, miau.toString());
                }
                // реализация метода возвращает строку
                return string;
            }
        }
        // а реализация этого метода как и должна возвращает объект класса, который реализует интрефейс Sayable
        return new CatPet();
    }
}