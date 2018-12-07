package com.javarush.task.task29.task2912;

public abstract class AbstractLogger implements Logger {
    private int level;
    private Logger next;

    // замена конструктора по умолчанию
    public AbstractLogger(int level) {
        this.level = level;
    }

    // метод информирования
    @Override
    // принимает сообщение и уровень тревоги
    public void inform(String message, int level) {
        // если переданный уровень тревоги больше либо равен значению в объекте, то вызываю метод info
        if (this.level <= level) {
            info(message);
        }
        // если у объекта есть подключенный следующий логгер, то передаю параметры его методу
        // и так движение идет по всей цепочке подключенных логеров
        if (next != null) {
            next.inform(message, level);
        }
    }

    // по сути обычный сеттер поля
    // метод связвает текущий объект логгера с еще одним объектом,
    // который так же реализует интерфейс логгера
    @Override
    public void setNext(Logger next) {
        this.next = next;
    }
}
