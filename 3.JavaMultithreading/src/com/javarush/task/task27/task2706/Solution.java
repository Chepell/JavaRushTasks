package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
Используя стратегию избегания deadlock-а сделай так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуй аналогично примеру из лекций.
Изменения вноси только в safeMethod.
*/
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        int hashCode1 = System.identityHashCode(obj1);
        int hashCode2 = System.identityHashCode(obj2);
        Object objMax = hashCode1 > hashCode2 ? obj1 : obj2;
        Object objMin = hashCode1 > hashCode2 ? obj2 : obj1;

        synchronized (objMax) {
            longTimeMethod();
            synchronized (objMin) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}