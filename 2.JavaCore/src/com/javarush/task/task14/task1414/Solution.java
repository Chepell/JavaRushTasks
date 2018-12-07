package com.javarush.task.task14.task1414;

/* 
MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".

Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
6. Добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".
7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "thriller", "soapOpera".
8. Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().


Требования:
1. Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.
2. Метод MovieFactory.getMovie должен возвращать объект типа Cartoon
    в случае передачи ему строки "cartoon" в качестве параметра.
3. Метод MovieFactory.getMovie должен возвращать объект типа Thriller
в случае передачи ему строки "thriller" в качестве параметра.
4. Метод main должен считывать строки с клавиатуры.
5. Метод main должен прекращать считывать строки с клавиатуры в случае,
    если была введена некорректная строка(не "cartoon", не "thriller" или не "soapOpera").
6. Для каждой введенной строки (в том числе для некорректной) необходимо вызвать метод MovieFactory.getMovie.
7. Для всех введенных корректных строк необходимо вывести на экран
    простые имена(movie.getClass().getSimpleName()) типов объектов возвращаемых методом MovieFactory.getMovie.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // первый ввод ключа строки
        String key;// = reader.readLine().toLowerCase();
        // объявления пустой переменной за пределами цикла для хранения созданных объектов
        Movie movie = null;
//        // елси ключ соответствующий, то заходим в цикл
//        while ("soapopera".equals(key) || "cartoon".equals(key) || "thriller".equals(key)) {
//            // используя метод по введенному ключу инициирую переменную новым объектом соответствующего класса
//            movie = MovieFactory.getMovie(key);
//            // вывожу на экран имя класса созданного объекта
//            System.out.println(movie.getClass().getSimpleName());
//            // в конце цикла еще раз запрашиваю ввод key с клавиатуры
//            // и либо опять входу в цикл, либо покидаю его
//            key = reader.readLine().toLowerCase();
//        }

        // елси ключ соответствующий, то заходим в цикл
        do {
            key = reader.readLine();
            // используя метод по введенному ключу инициирую переменную новым объектом соответствующего класса
            movie = MovieFactory.getMovie(key);
            // вывожу на экран имя класса созданного объекта
            try {
                System.out.println(movie.getClass().getSimpleName());
            } catch (NullPointerException e) {

            }
            // в конце цикла еще раз запрашиваю ввод key с клавиатуры
            // и либо опять входу в цикл, либо покидаю его

        } while ("soapOpera".equals(key) || "cartoon".equals(key) || "thriller".equals(key));
    }

    // класс только для получения доступа к методу класса
    static abstract class MovieFactory {
        // метод для создания объекта конкретного класса абстрактного класса Movie
        static Movie getMovie(String key) {
            // объявляю переменную для объекта абстратного класса Movie
            // но хранится в нем будут только реальные объекты классов-наследников
            Movie movie = null;
            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            // метод возвращает созданный объект
            return movie;
        }
    }

    // абстрактный класс родитель
    static abstract class Movie {
    }

    // реальные наследники
    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }

}
