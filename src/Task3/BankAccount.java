package Task3;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " внес " + amount + ". Текущий баланс: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " снял " + amount + ". Текущий баланс: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " не смог снять " + amount + " (недостаточно средств). Текущий баланс: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}
