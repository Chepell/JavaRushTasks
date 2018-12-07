package com.javarush.task.task30.task3003;

import java.util.Objects;

//This class shows how to call other constructors using 'this'
public class ShareItem {
    public String description;
    public int itemId;

    // вариации конструкторов на основе базового
    // параметры не передаются
    public ShareItem() {
        this("Test Item", 0);
    }

    // тут один передается, другой заполяется
    public ShareItem(String description) {
        this(description, 0);
    }

    // наоборот, один заполняется, другой передается
    public ShareItem(int itemId) {
        this("Test Item", itemId);
    }

    // базовый конструктор с обоими параметрами
    public ShareItem(String description, int itemId) {
        this.description = description;
        this.itemId = itemId;
    }

    // геттеры
    public String getDescription() {
        return description;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareItem shareItem = (ShareItem) o;
        return itemId == shareItem.itemId &&
                Objects.equals(description, shareItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, itemId);
    }

    @Override
    public String toString() {
        return "ShareItem{" +
                "description='" + description + '\'' +
                ", itemId=" + itemId +
                '}';
    }

}
