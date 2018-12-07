package com.javarush.task.task22.task2201;

// класс исключений реализующий интерфейс неперехватывающих интерфейсов потока
public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    // тут в качестве параметра использую e.getCause() это будет переданное параметром в конструкторе исключение
    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
    }

    // t.getName() - возвращает строку имени переданную в конструктор new Thread(obj, name);
    // e.getClass().getSimpleName() - вернет имя класса моего исключения
    // e.getCause() - вернет реальную причину исключения, которая параметром передана в мой класс исключений
    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(string,t.getName(), e.getClass().getSimpleName(), e.getCause());
    }
}

