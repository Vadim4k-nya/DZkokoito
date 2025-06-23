package Task3;

import java.util.Random;

public class AccountThread implements Runnable {
    private BankAccount account;
    private int operationsCount;
    private Random random = new Random();

    public AccountThread(BankAccount account, int operationsCount) {
        this.account = account;
        this.operationsCount = operationsCount;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " запускается.");
        for (int i = 0; i < operationsCount; i++) {
            int amount = random.nextInt(100) + 1;
            if (random.nextBoolean()) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            try {
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " был прерван.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
    }
}
