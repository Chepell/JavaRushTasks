package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

import java.util.ArrayList;
import java.util.List;

// кэширование сервисов
public class Cache {
    // поле список для хранения сервисов
    private List<Service> services;

    // инициализация поля в конструкторе
    public Cache() {
        services = new ArrayList<>();
    }

    // получение сервиса по имени из списка/кэша
    public Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Return cached  " + serviceName + " object");
                return service;
            }
        }
        return null; // если  сервис не найден, то возвращаем Null
    }

    // добавление сервиса в список
    public void addService(Service newService) {
        boolean exists = false;
        // сначала проход по списку сервисов и проверка что его еще нет в списке
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName())) exists = true;
        }
        // в условие входим и добавляем в список новый сервис если так же не был найден в списке
        if (!exists) services.add(newService);
    }
}
