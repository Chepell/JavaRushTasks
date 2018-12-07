package com.javarush.task.task14.task1411;

// интересный интерфейс
public interface Person {
    // внутри интрефейса несколько классов, которые реализуют этот интерфейс
    class User implements Person {
        // реализованные методы классов, это ведь уже не интерфейс
        void live() {
            System.out.println("Usually I just live.");
        }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("Usually I do nothing.");
        }
    }

    class Coder implements Person {
        void coding() {
            System.out.println("Usually I create code.");
        }
    }

    class Proger implements Person {
        void enjoy() {
            System.out.println("Wonderful life!");
        }
    }

}
