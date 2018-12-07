package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

// абстрактный класс как-то расширяющий дженерики
public abstract class AbstractDbSelectExecutor<T extends NamedItem> {
    // абстрактный метод класса возвращающий строку
    public abstract String getQuery();

    /**
     * It's fake method
     *
     * @return a list of 5 fake items
     */
    // метод возвращает список объектов Т
    public List<T> execute() {
        // создается список
        List<T> result = new ArrayList<>();
        // созраняю запрос в строковую переменную
        String query = getQuery();
        // если переменная пустая, то возвращаю список
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Got by executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    // reflection
    // you have to know that it is possible to create new instance of
    // T (generic type) class by using its default constructor
    // this.getClass() - сначала мы получаем класс нашего объекта (созданного от анонимного класса).
    // getGenericSuperclass() - потом мы получаем дженерик нашего суперкласса
    // AbstractDbSelectExecutor (может быть User, Location и т.д.).
    // (ParameterizedType) - потом приводим все это к параметризированному типу. По сути, это тоже самое что и
    // было (оба Type), но у этого интерфейса есть метод getActualTypeArguments().
    //
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
