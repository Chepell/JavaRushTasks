package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
В методе main присвой объекту Object obj экземпляр класса TEST.
Не изменяй ничего кроме метода main.


Требования:
1. В классе Solution должно существовать поле TEST.
2. В классе Solution должен существовать класс TEST.
3. В классе Solution должно существовать поле obj.
4. В методе main в поле obj должен быть сохранен объект типа TEST(экземпляр класса TEST).
*/
public class Solution {
    // просто статичное поле класса, константа
    public static final String TEST = "test";

    // статичный вложенный класс
    // static nested class
    public static class TEST {
        // переопределение метода класса по печати содержимого объекта класса
        @Override
        public String toString() {
            return "test class";
        }
    }

    // создаю переменную ссылку на объект суперкласса
    static Object obj;

    public static void main(String[] args) {
        // инициирую переменную, к статичному вложенному классу обращаюсь через имя внешнего класса
        obj = new Solution.TEST();
        System.out.println(obj);
    }
}
