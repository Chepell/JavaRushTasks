package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
Установить модификатор synchronized только тем методам, которым необходимо.
Объект класса Solution будет использоваться нитями.


Требования:
1. В method0, если необходимо, используй synchronized.
2. В method1, если необходимо, используй synchronized.
3. В method2, если необходимо, используй synchronized.
4. В method3, если необходимо, используй synchronized.
5. В method4, если необходимо, используй synchronized.
6. В method5, если необходимо, используй synchronized.
7. В method6, если необходимо, используй synchronized.
8. В method7, если необходимо, используй synchronized.
*/

public class Solution {
    // случайное число
    private double param = Math.random();
    // объект класса построителя строк
    private StringBuilder sb = new StringBuilder();


    // вроде как атомарный метод, берет просто значение
    private void method0() {
        Double d = method3();
    }

    // метод создает объект класса и вызывает метод0
    // вроде атомарный
    protected void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }

    // метод точно не атомарный
    // но метод не изменяет общие ресурсы и не вызывает других методов
    public void method2(int param1) {
        param1++;
    }

    // точно не атомарный т.к. изменяет общие ресурсы
    synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    // думаю не атомарный метод
    // метод меняет общий объект
    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    // метод не изменяет общие ресурсы
    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    // изменяет общие ресурсы
    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    // не меняет общие ресурсы
    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args) {

    }

}
