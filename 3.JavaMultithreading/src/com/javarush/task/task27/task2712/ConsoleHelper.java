package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderedDishesList = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда:");

        while (true) {
            String readLine = reader.readLine();
            if ("exit".equalsIgnoreCase(readLine)) break;

            try {
                Dish dish = Dish.valueOf(readLine);
                orderedDishesList.add(dish);
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет в меню...");
            }
        }
        return orderedDishesList;
    }
}