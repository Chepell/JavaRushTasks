package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State state, lastState = null;
        do {
            // считываю состояние
            state = target.getState();
            // если сотояние изменилось по сравнию с другой перменой
            if (state != lastState) {
                // то вывожу на экран состояние
                System.out.println(state);
                // и обновляю значение переменной
                lastState = state;
            }
            // цикл продолжается пока поток не будет закрыт, тогда цикл прервется
            // и run() завершится и тем самым завершится и текущий поток
        }
        while (state != State.TERMINATED);


//        Thread current = Thread.currentThread();
////        while (!target.isInterrupted()) {
//            System.out.println(target.getState());
////            if (target.getState() == State.TERMINATED) {
////                break;
////            }
////
////            if () {
////            }
////        }
//        if (target.isInterrupted()) {
//            current.interrupt();
//        }
    }
}
