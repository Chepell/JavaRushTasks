package com.javarush.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
1. В методе sort написать компаратор для Stock:
1.1. Первичная сортировка по name в алфавитном порядке
1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые), потом по прибыли от положительных к отрицательным

... open 125,64 and last 126,74 - тут прибыль = 126,74-125,64
... open 125,64 and last 123,43 - тут прибыль = 123,43-125,64

2. Разобраться с *Format-ами и исправить IllegalArgumentException.
Подсказка - это одна строчка.

Пример вывода:
Fake Apple Inc. AAPL | 17-11-2025 open 125,64 and last 123,43
Fake Applied Materials, Inc. AMAT | 15-01-1983 closed 0,26


Требования:
1. Во время работы программы не должны возникать исключения.
2. Программа должна выводить данные на экран.
3. Метод sort должен корректно сортировать полученный список в соответствии с условием задачи.
4. Класс Solution.Stock должен быть публичным.
*/
public class Solution {
    public static void main(String[] args) {
        // создается список объектов типа Stock c помощью метода, который внутри себя создает и возвращает список
        List<Stock> stocks = getStocks();
        // вызов метода, который реализует сортировку списка
        sort(stocks);
        // создается объект текущей даты
        Date actualDate = new Date();
        // метод печати списка
        printStocks(stocks, actualDate);
    }

    // метод печати данных из списка, параметрами принимает список и текущую дату
    public static void printStocks(List<Stock> stocks, Date actualDate) {
        // объект для форматирования даты
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // массив типа double, сразу наполняется двумя элементами
        // 0 в double формате зачем-то, итак ведь подошел бы, cast был бы автоматическим
        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        // циклом иду по списку акций
        for (Stock stock : stocks) {

            String name = (String) stock.get("name");
            String symbol = (String) stock.get("symbol");
            // тут вытаскиваю данные согластно конструктора, который использовался
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    // метод для сортировки объектов списка
    public static void sort(List<Stock> list) {
        // вызывается метод сортировки, внутри создается Comparator в виде анонимного класса
        Collections.sort(list, Comparator
                .comparing(stock -> (String) ((Stock) stock).get("name"))
                .thenComparing(stock -> (Date) ((Stock) stock).get("date"), Comparator.reverseOrder())
                .thenComparing(stock -> ((Stock) stock).containsKey("change") ?
                        (double) ((Stock) stock).get("change") :
                        (double) ((Stock) stock).get("last") - (double) ((Stock) stock).get("open"), Comparator.reverseOrder()));
    }

//    // метод для сортировки объектов списка
//    public static void sort(List<Stock> list) {
//        // вызывается метод сортировки, внутри создается Comparator в виде анонимного класса
//        Collections.sort(list, new Comparator<Stock>() {
//            public int compare(Stock stock1, Stock stock2) {
//                String name1 = (String) stock1.get("name");
//                String name2 = (String) stock2.get("name");
//                Date date1 = (Date) stock1.get("date");
//                Date date2 = (Date) stock2.get("date");
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//                int intDate1 = Integer.parseInt(dateFormat.format(date1));
//                int intDate2 = Integer.parseInt(dateFormat.format(date2));
//                double open1 = !stock1.containsKey("open") ? 0 : ((double) stock1.get("open"));
//                double last1 = !stock1.containsKey("last") ? 0 : ((double) stock1.get("last"));
//                double change1 = !stock1.containsKey("change") ? 0 : ((double) stock1.get("change"));
//                double open2 = !stock2.containsKey("open") ? 0 : ((double) stock2.get("open"));
//                double last2 = !stock2.containsKey("last") ? 0 : ((double) stock2.get("last"));
//                double change2 = !stock2.containsKey("change") ? 0 : ((double) stock2.get("change"));
//                // если value change не пустое, то использую его в качестве прибыли
//                // иначе вычисляю прибыль как разность текущей цены и цены открытия
//                double profit1 = change1 != 0 ? change1 : last1 - open1;
//                double profit2 = change2 != 0 ? change2 : last2 - open2;
//
//                // если названия акций не равны, то сравниваю по ним
//                if (name1.compareTo(name2) != 0) {
//                    return name1.compareTo(name2);
//                }
//
//                // иначе сравниваю по датам в обратном порядке
//                if (intDate1 > intDate2) {
//                    return -1; // тут -1 что бы был вывод от большего к меньшему
//                } else if (intDate1 < intDate2) {
//                    return 1;
//                }
//                // иначе сравниваю по прибыли в обратном порядке
//                if (profit1 > profit2) {
//                    return -1; // тут -1 что бы был вывод от большего к меньшему
//                } else if (profit1 < profit2) {
//                    return 1;
//                }
//                // если дошли сюда, то объекты равны
//                return 0;
//            }
//
//        });
//    }

    // класс наследний от HashMap
    public static class Stock extends HashMap {
        // имеет два конструктора, которые добавляю немного разные данные
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        // конструктор для закрытых позиций
        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("change", change);
            put("date", date);
        }
    }

    // метод создает список
    public static List<Stock> getStocks() {
        // объявление и инициализация списка
        List<Stock> stocks = new ArrayList();

        // добавление значений с использованием первого конструктора, дата случайначна начиная с 2020 года
        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));
        // добавление пар key-value на основе второго конструктора, это уже закрытые в прошлом сделки
        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));
        // в итоге возвращается список объектов типа HashMap
        return stocks;
    }

    // метод возвращает случаюнйю дату нчинаюя с 1970, просто метод с нужной датой вызывается внутри
    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    // метод генерации слчайной даты, параметром передается стартовый год
    public static Date getRandomDate(int startYear) {
        // тут граница в 30 лет начиная со startYear, т.к. Math.RANDOM() возвращает
        // значение от 0 до 1 и потом это умножается на 30
        int year = startYear + (int) (Math.random() * 30);
        // тут не более 12 месяцев
        int month = (int) (Math.random() * 12);
        // а тут для упрощения не более 28 дней
        int day = (int) (Math.random() * 28);
        // полученный значения передаются параметрами в конструктор объекта типа GregorianCalendar
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        // далее на объекте вызывается метод преобразующий его в объект типа Date, который метод и возвращает
        return calendar.getTime();
    }
}

