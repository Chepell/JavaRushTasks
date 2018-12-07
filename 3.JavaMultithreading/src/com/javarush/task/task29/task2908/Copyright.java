package com.javarush.task.task29.task2908;

// хм, класс при парамеризации интерфейса в качестве аргумента принимает внутренний класс
public class Copyright implements Computable<Copyright.Period, String> {
    // реализация метода интерфейса
    @Override
    public String compute(Period period) throws InterruptedException {
        return "All rights reserved (c) " + period.firstYear + "-" + period.secondYear;
    }

    // внутренний класс
    public static class Period {
        // два поля класса
        int firstYear;
        int secondYear;

        // конструктор принимающий значения для полей класса
        public Period(int firstYear, int secondYear) {
            this.firstYear = firstYear;
            this.secondYear = secondYear;
        }

        // переопределение стандартного метода
        @Override
        public String toString() {
            return "Period{" +
                    "firstYear=" + firstYear +
                    ", secondYear=" + secondYear +
                    '}';
        }

        // реализация методов для сравнения и сортировки обхектов
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Period)) return false;

            Period period = (Period) o;

            if (firstYear != period.firstYear) return false;
            if (secondYear != period.secondYear) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = firstYear;
            result = 31 * result + secondYear;
            return result;
        }
    }
}
