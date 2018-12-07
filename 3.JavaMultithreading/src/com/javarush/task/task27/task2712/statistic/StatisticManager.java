package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        if (data == null) return; // проверка, что аргумент переданн не пустой
        statisticStorage.put(data);
    }

    // метод для получения из хранилища данных по рекламе
    public Map<String, Double> getAdvertisementProfit() {
        // Получаю список данных из хранилища по рекламе в список
        List<EventDataRow> videos = statisticStorage.getAllRowsOfType(EventType.SELECTED_VIDEOS);
        // Создаю мэп, в которую буду складывать отформатированные результаты
        // мэп с автоматической сортировкой, при инициализации указываю обратный порядок сортировки
        Map<String, Double> resultMap = new TreeMap<>(Collections.reverseOrder());
        // итерируюсь по списку
        for (EventDataRow video : videos) {
            // делаю кастинг записи из интерфейса в объект заданного класса
            VideoSelectedEventDataRow videoRow = (VideoSelectedEventDataRow) video;
            // получаю поле даты из объекта и конвертирую в строку в нужном формате
            String date = getFormatStringDate(videoRow.getDate());
            double amount = videoRow.getAmount() / 100.0;
            // Если записи с такой датой в мэпе нет
            if (!resultMap.containsKey(date)) {
                // Добавляем новую запись
                resultMap.put(date, amount);
            } else {
                // Иначе обновляем запись с новой суммой
                resultMap.put(date, resultMap.get(date) + amount);
            }
        }
        return resultMap; // возвращаю итоговый мэп
    }

    public Map<String, Map<String, Integer>> getCookWorkloading() {
        //Получаем список данных из хранилища
        List<EventDataRow> cookedOrders = statisticStorage.getAllRowsOfType(EventType.COOKED_ORDER);
        //Создаем карту, в которую будем складывать результаты
        //Группировка по дате, вторая группировка по повару.
        Map<String, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow cookedOrder : cookedOrders) {
            // делаю кастинг записи из интерфейса в объект заданного класса
            CookedOrderEventDataRow orderRow = (CookedOrderEventDataRow) cookedOrder;
            // получаю поле даты из объекта и конвертирую в строку в нужном формате
            String date = getFormatStringDate(orderRow.getDate());
            // Получаю имя повара
            String cookName = orderRow.getCookName();
            // Получаем время работы повара
            Integer workTime = orderRow.getTime();
            // Если время > 0, то обрабатываем запись.
            if (workTime > 0) {
                // Если запись с датой уже есть
                if (resultMap.containsKey(date)) {
                    // Получаем все записи с этой датой
                    Map<String, Integer> cooks = resultMap.get(date);
                    // Если запись с поваром уже есть
                    if (cooks.containsKey(cookName)) {
                        // Обновляем запись с новой суммой времени
                        cooks.put(cookName, cooks.get(cookName) + workTime);
                    } else {
                        //Иначе добавляем нового повара
                        cooks.put(cookName, orderRow.getTime());
                    }
                } else {
                    //Если записи с датой нет, то добавляем новую запись
                    resultMap.put(date, new TreeMap<>()); // сначала инициирую value как TreeMap
                    resultMap.get(date).put(cookName, workTime);
                }
            }
        }
        return resultMap;
    }

    // метод для конверации даты в строку без учета времени
    private String getFormatStringDate(Date date) {
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date);
    }

    // внутренний приватный класс хранилище событий
    private class StatisticStorage {
        // поле хранилище в виде мэпа
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        // конструктор с инициализацией поля класса
        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        // метод добавления записи в хранилище
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        // метод для получения значения (списка) из поля класса по ключу
        private List<EventDataRow> getAllRowsOfType(EventType eventType) {
            return storage.get(eventType);
        }
    }
}


