package com.javarush.task.task17.task1715;

import java.util.HashMap;
import java.util.Map;

public class DrugsController {
    // мэп для хранения лекраств, объектов класса Drug, единый для всех объектов класса
    public static Map<Drug, Integer> allDrugs = new HashMap<Drug, Integer>();   // <Лекарство, Количество>

    // статик-блок наполняет мэп несколькими лекарствами в момент первой инициализации
    static {
        Drug panadol = new Drug();
        panadol.setName("Панадол");
        allDrugs.put(panadol, 5);

        Drug analgin = new Drug();
        analgin.setName("Анальгин");
        allDrugs.put(analgin, 18);

        Drug placebo = new Drug();
        placebo.setName("Плацебо");
        allDrugs.put(placebo, 1);
    }

    // публичный метод продающий лекасрства (уменьшающий/убирающий в мэпе)
    public synchronized void sell(Drug drug, int count) {
        // сохраняю имя текущего потока, кто запросил лекарство
        String name = Thread.currentThread().getName();
        // проверяю наличие лекарства
        if (!allDrugs.containsKey(drug)) {
            System.out.println("Нет в наличии");
        }
        // сохраняю доступное количество в переменную
        Integer currentCount = allDrugs.get(drug);
        // если доступное количество меньше чем что есть в наличии
        if (currentCount < count) {
            System.out.println(String.format("%s хочет %s %d шт. В наличии - %d", name, drug.getName(), count, currentCount));
        } else { // если в наличии достаточно лекарства, то продаю его, уменьшая доступное количество
            // как бы добавляю запись с новым количеством, но т.к. дубликатов по key быть не может, то будет перезаписано поле value
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s купил(а) %s %d шт. Осталось - %d", name, drug.getName(), count, (currentCount - count)));
        }
    }

    // публичный метод закупающий лекарства (добалвющий их в мэп) в указанном count количестве
    public synchronized void buy(Drug drug, int count) {
        // строка выводит что закупаем и в каком количестве
        System.out.println("Закупка " + drug.getName() + " " + count);
        // проверка, а есть ли такое лекарство в мэпе
        if (!allDrugs.containsKey(drug)) {
            // если нет, то добавляем запись в мэп
            // а количество пока ставим 0
            allDrugs.put(drug, 0);
        }
        // теперь занимаемся количеством
        // беру их мэпа текущее количество добавляемого лекарства
        Integer currentCount = allDrugs.get(drug);
        // и обновляю в мэпе его значение суммированием
        allDrugs.put(drug, (currentCount + count));
    }
}
