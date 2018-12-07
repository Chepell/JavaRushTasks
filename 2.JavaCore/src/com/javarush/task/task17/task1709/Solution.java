package com.javarush.task.task17.task1709;

/* 
Предложения
Не используя synchronized сделай так, чтобы количество сделанных и принятых предложений было одинаковым.


Требования:
1. Класс Solution должен содержать нить MakeProposal.
2. Класс Solution должен содержать нить AcceptProposal.
3. Класс Solution должен содержать публичную статическую переменную int proposal.
4. Программа не должна содержать synchronized методов или synchronized блоков.
5. Переменная int proposal не должна находится в локальном кэше.
*/

public class Solution {
    public volatile static int proposal = 0;

    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    // класс пишет в переменную
    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    // ждет 100 мс, за это время другой поток точно проверит изменение
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    // класс только читает из переменной
    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            // считываю значение общей статичной волатайл переменной в свою
            int thisProposal = proposal;

            // цикл продолжается пока не дошли до 10
            while (thisProposal < 10) {
                // проверка, что значение proposal изменилось после инциализации до начала цикла
                if (thisProposal != proposal) {
                    // если изменилось, значит принимаю предыдущее предложение
                    System.out.println("Принято предложение №" + proposal);
                    // и обновляю значение переменной
                    thisProposal = proposal;
                }

            }
        }
    }
}
