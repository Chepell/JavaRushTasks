package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    // метод итерируется по списку блюд в перечислении
    // и генератором проверяет добавлять или нет блюдо в список
    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        for (Dish dish : Dish.values()) {
            if ((int) (ThreadLocalRandom.current().nextDouble() * 2) == 1) {
                dishes.add(dish);
            }
        }
    }
}
