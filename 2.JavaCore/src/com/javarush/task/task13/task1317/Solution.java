package com.javarush.task.task13.task1317;

/* 
The weather is fine
1. В классе Today реализовать интерфейс Weather.
2. Подумай, как связан параметр type с методом getWeatherType().
3. Интерфейсы Weather и WeatherType уже реализованы в отдельных файлах.


Требования:
1. Интерфейс Weather должен быть реализован в классе Today.
2. В классе Today должен быть реализован метод getWeatherType объявленный в интерфейсе Weather.
3. Тип возвращаемого значения метода getWeatherType должен быть String.
4. Метод getWeatherType должен возвращать значение переменной type.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }

    static class Today implements Weather {
        // приватное поле класса
        private String type;

        // конструктор класса
        Today(String type) {
            this.type = type;
        }

        // реалиазция метода интерфейса
        public String getWeatherType() {
            return type;
        }

        // переопределение, так что в форматировнное строке пишется поданный аргумент
        @Override
        public String toString() {
            return String.format("%s for today", this.getWeatherType());
        }
    }
}