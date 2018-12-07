package com.javarush.task.task17.task1720;

import java.math.BigDecimal;

public class BankAccount {
    // такой тип данных нужен что бы попасть на проблеме округления в double
    private BigDecimal balance;
    private String owner;

    // конструктор класса, только имя, баланс нулевой
    public BankAccount(String owner) {
        // реализациия интересная, раньше не видел
        this(BigDecimal.ZERO, owner);
        // тоже самое что и
//        this.balance = BigDecimal.ZERO;
//        this.owner = owner;
    }

    // полный конструктор класса
    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    // метод пополнение счета, для нитей должен быть синхронизирован
    public synchronized void deposit(BigDecimal money) {
        // переменная для нового баланса
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        // обновление значения поля объекта
        balance = newBalance;
    }

    // метод снятия денег со счета, для нитей должен быть синхронизирован
    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = balance.subtract(money);
        // проверка что баланс счета не стал отрицательным, тогда выбрасываем исключение
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    // Делегирование метода для использования ввода строк в качестве сумм
    // и так же синхронизирую
    public synchronized void deposit(String money) {
            deposit(new BigDecimal(money));
    }

    // Делегирование метода для использования ввода строк в качестве сумм
    // и так же синхронизирую
    public synchronized void withdraw(String money) throws NotEnoughMoneyException {
            withdraw(new BigDecimal(money));
    }
}
