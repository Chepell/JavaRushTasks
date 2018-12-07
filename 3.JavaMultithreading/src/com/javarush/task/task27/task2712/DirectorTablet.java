package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

// класс планшета для директора
public class DirectorTablet {
    private StatisticAdvertisementManager advertisementManager = StatisticAdvertisementManager.getInstance();

    // метод для отображения статистики по рекламе
    public void printAdvertisementProfit() {
        Map<String, Double> statMap = StatisticManager.getInstance().getAdvertisementProfit();
        double totalAmount = 0; // переменная для расчета суммарной прибыли за все время
        for (Map.Entry<String, Double> entry : statMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %.02f", entry.getKey(), entry.getValue()));
            totalAmount += entry.getValue();
        }
        // если прибыль не нулевая, то вывожу на консоль
        if (totalAmount > 0) {
            ConsoleHelper.writeMessage(String.format("Total - %.02f", totalAmount));
        }
    }

    // метод для отображения статистики по занятости поваров
    public void printCookWorkloading() {
        // получение из хранилища мэпа где ключем идет дата, а значением
        // идет второй мэп из имения повара и занятости в секундах
        Map<String, Map<String, Integer>> statMap = StatisticManager.getInstance().getCookWorkloading();
        // итерируюсь по внешнему мепу
        for (Map.Entry<String, Map<String, Integer>> entryMap : statMap.entrySet()) {
            // вывожу ключ (дату) на консоль
            ConsoleHelper.writeMessage(entryMap.getKey());
            // после чего итерируюсь по внутреннему мепу, имяПовара : время
            for (Map.Entry<String, Integer> entry : entryMap.getValue().entrySet()) {
                String cookName = entry.getKey();
                // конвертирую время в минуты округлив до целого
                int workTime = (int) Math.round(entry.getValue() / 60.0);
                // вывожу пару на экран
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
            }
            ConsoleHelper.writeMessage(""); // пустая строка между дневными записями
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideoList = advertisementManager.activeVideoList();
        activeVideoList.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
        for (Advertisement ad : activeVideoList) {
            String name = ad.getName();
            int hits = ad.getHits();
            ConsoleHelper.writeMessage(name + " - " + hits);
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> archiveVideoList = advertisementManager.archiveVideoList();
        archiveVideoList.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
        for (Advertisement ad : archiveVideoList) {
            String name = ad.getName();
            ConsoleHelper.writeMessage(name);
        }
    }
}
