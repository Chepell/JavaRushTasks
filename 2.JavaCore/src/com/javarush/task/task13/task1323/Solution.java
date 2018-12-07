package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
Реализовать интерфейс Updatable в классе Screen.


Требования:
1. Интерфейс Updatable должен наследовать(extends) интерфейс Selectable.
2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    // интерфейс наследуется от другого интерфейса
    interface Updatable extends Selectable {
        void refresh();
    }

    // класс реализует интерфейс
    // а в итоге из-за наследования у интерфейсов целых два
    class Screen implements Updatable{

        // реализация методов интерфейса
        @Override
        public void onSelect() {

        }

        @Override
        public void refresh() {

        }
    }
}
