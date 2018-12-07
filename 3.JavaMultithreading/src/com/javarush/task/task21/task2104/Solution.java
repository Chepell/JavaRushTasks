package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии
с правилами реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с
помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.


Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны
    у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
*/
public class Solution {
    // константные приватные поля класса
    private final String first, last;

    // конструктор в котором поля один раз определяются
    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override // аннотация позволяет измежать ошибок в сигнатуре, инче будет перегрузка метода
    public boolean equals(Object o) {
        // базовая проверка, что объекты равны когда ссылки указывают на один и тот же объект
        if (this == o) return true;
        // если на сравнение подан нулевой указатель, либо классы объектов не равны
        if (o == null || getClass() != o.getClass()) return false;
        // принудительное приведение типа объекта к текущему классу
        Solution solution = (Solution) o;
        // сравнение полей через null безопастный метод
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {
        // нативный метод определения хэш-функции
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        // создаю хешмножество объектов класса Solution
        Set<Solution> s = new HashSet<>();
        // добавляю новый объект в множество
        s.add(new Solution("Donald", "Duck"));



        Solution don = new Solution("Donald", "Duck");
        // проверяю а есть ли такой объект в множестве фактически создавая такой же объект в метода
        System.out.println(s.contains(don));
        System.out.println(don.hashCode());
        System.out.println(new Solution("Donald", "Duck").hashCode());

    }
}
