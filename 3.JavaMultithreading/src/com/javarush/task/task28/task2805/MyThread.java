package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger priority = new AtomicInteger(0);

    synchronized private void priority() {
        // сразу инкрементирую значение что бы было 1
        priority.incrementAndGet ( );
        // проверяю если стало больше 10, то возвращаю 1
        priority.compareAndSet (11, 1);
        // сохраняю значение в переменную
        int newPriority = priority.get ( );
        // проверяю есть ли группа нитей, то просто использую переменную и занчение в предыдущей строке
        if (getThreadGroup() != null) {
            // проверяю не больше ли сохраненное значение потока максимального в группе
            if (newPriority > getThreadGroup().getMaxPriority()) {
                // если больше то приравниваю значение к максимальному
                newPriority = getThreadGroup().getMaxPriority();
            }
        }
        // эта конструкция фактически заменена перевыми двумя строками метода
//        if (priority.get() < 10) {
//            priority.incrementAndGet();
//        } else {
//            priority.set(1);
//        }
        // в конце вызываю метод установки приоритета и передаю
        this.setPriority(newPriority);
    }

    // все конструкторы добавлены через Alt+Insert
    public MyThread() {
        this.priority();
    }

    public MyThread(Runnable target) {
        super(target);
        this.priority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.priority();
    }

    public MyThread(String name) {
        super(name);
        this.priority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.priority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.priority();
    }
}

// В отдельном файле создай класс MyThread унаследовавшись от Thread. MyThread должен:
//1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
//2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
//3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть
// больше максимального приоритета его трэд-группы.
//
//
//Требования:
//1. Создай класс MyThread в отдельном файле. Унаследуй его от Thread.
//2. В классе MyThread должны присутствовать конструкторы, аналогичные конструкторам супер-класса.
//3. Приоритет у объектов MyThread должен проставляться циклично, от MIN_PRIORITY до MAX_PRIORITY.
//4. Если у объекта MyThread установлена ThreadGroup, приоритет MyThread
// не должен быть выше максимального приоритета ThreadGroup.
