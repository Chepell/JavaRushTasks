package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
Реализуй логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе
someMethodWithSynchronizedBlocks - порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот - false.

Требования:
1. Метод isNormalLockOrder должен возвращать true в случае,
если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
2. Метод isNormalLockOrder должен возвращать false в случае,
если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
3. Метод isNormalLockOrder НЕ должен быть приватным.
4. Класс Solution НЕ должен быть объявлен с модификатором final.

*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        // синхронизация по первому объекту в нити, внутри блока сон 1сек, т.е. блокирую мьютекс объекта 1
        thread1.start();
        Thread.sleep(100);
        // запускаю метод, пробую последовательно заблокировать 1й и 2й объект
        thread2.start();
        // нить питается использовать мьютекс 2го объекта, если не может, то нить блокируется
        // если нить блокируется, то значит порядок был нарушен и вторая нить не остановилась сразу
        // т.к. объект1 должен был быть заблокирован
        thread3.start();
        Thread.sleep(100);
        // и проверяю состояние 3ей нити, если заблокирована, то возвращаю false, порядок был нарушен
        if (thread3.getState().equals(Thread.State.BLOCKED)) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
