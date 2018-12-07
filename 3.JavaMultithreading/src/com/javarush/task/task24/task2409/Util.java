package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    // объявление статичного массива объектов jeans в виде LinkedList
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    // в статичном блоке добавление объектов в массив
    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    // метод возвращает список объектов типа Jeans
    public static List<Jeans> getAllJeans() {

        abstract class AbstractJeans implements Jeans {

            private int length;
            private int size;
            private int id;
            private double price;
            private String tm;


            public AbstractJeans(int length, int size, int id, double price) {
                this.length = length;
                this.size = size;
                this.id = id;
                this.price = price;
                this.tm = this.getClass().getSimpleName();
            }

            @Override
            public int getLength() {
                return length;
            }

            @Override
            public int getSize() {
                return size;
            }

            @Override
            public int getId() {
                return id;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public String getTM() {
                return tm;
            }

            @Override
            public String toString() {
                return this.getClass().getSimpleName() + "{id=" + id + ", length=" + length + ", size=" + size + ", price=" + price + "}";
            }
        }

//        2.5) метод toString класса AbstractJeans должен начинаться с имени подкласса,
//                например, Levis{id=1, length=34, size=6, price=150.0}

        class Levis extends AbstractJeans {
            public Levis(int length, int size, int id, double price) {
                super(length, size, id, price);
                super.tm = this.getClass().getSimpleName();

            }
        }

        class Denim extends AbstractJeans {
            public Denim(int length, int size, int id, double price) {
                super(length, size, id, price);
                super.tm = this.getClass().getSimpleName();
            }
        }
        //add your code here
        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    public String getTM() {
                        return company.fullName;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    // метод массива объектов
    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        // конструктор для enum
        Company(String name) {
            this.fullName = name;
        }
    }
}

/*
Интернет-магазин продажи джинсов
1. Создай 2 интерфейса в отдельных файлах:
1.1) Item с методами int getId(), double getPrice(), String getTM()
1.2) Jeans extends Item с методами int getLength() и int getSize()

2. В классе Util в методе getAllJeans добавь пропущенную часть java-кода:
2.1) разберись в том, что уже есть в методе getAllJeans класса Util
2.2) создай абстрактный class AbstractJeans от интерфейса
Jeans с одним абстрактным методом, реализуй остальные методы
2.3) создай классы Levis и Denim от AbstractJeans, реализуй оставшийся метод
2.4) в классе AbstractJeans реализуй метод toString() (можешь воспользоваться Alt+Insert -> toString())
2.5) метод toString класса AbstractJeans должен начинаться с имени подкласса,
например, Levis{id=1, length=34, size=6, price=150.0}


Требования:
1. Интерфейс Item должен быть создан в отдельном файле.
2. Интерфейс Jeans должен расширять интерфейс Item и быть создан в отдельном файле.
3. В интерфейсе Item должны присутствовать все методы перечисленные в условии.
4. В классе Jeans должны присутствовать все методы перечисленные в условии.
5. В методе getAllJeans класса Util должен быть создан локальный
    абстрактный класс AbstractJeans, поддерживающий интерфейс Jeans.
6. В методе getAllJeans класса Util должен быть создан локальный класс Levis, унаследованный от класса AbstractJeans.
7. В методе getAllJeans класса Util должен быть создан локальный класс Denim, унаследованный от класса AbstractJeans.
8. В классе AbstractJeans должен быть реализован метод toString(), начинающийся с имени подкласса.
*/