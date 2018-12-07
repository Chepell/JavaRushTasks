package com.javarush.task.task23.task2309.vo;

// класс для перечисления любых вещей
public class NamedItem {
    // поля класса
    private int id;
    private String name;
    private String description;

    // пустой конструктор
    public NamedItem() {
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
