import java.util.Scanner;

import Task1.MyThread;
import Task2.Counter;
import Task2.SyncThread;
import Task3.AccountThread;
import Task3.BankAccount;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice == 1 || choice == 2 || choice == 3) {
            System.out.println("\n\nВыберите номер задания которое хочется проверить: ");
            choice = scanner.nextInt();
            checkTask(choice);
        }
    }

    public static void checkTask(int taskNumber) throws InterruptedException {
        if (taskNumber == 1) {
            System.out.println("\n\n### 1 Здание ###");



            MyThread thread1 = new MyThread("Поток 1");
            MyThread thread2 = new MyThread("Поток 2");

            Thread t1 = new Thread(thread1);
            Thread t2 = new Thread(thread2);

            t1.start();
            t2.start();

            System.out.println("Главный поток завершен.");

            t1.join();
            t2.join();

            System.out.println("\n\nНажмите Enter для подолжения...");
            new Scanner(System.in).nextLine();
        }
        else if (taskNumber == 2) {
            // ### Задание 2 ###
            System.out.println("\n\n### 2 Здание ###");

            Counter counter = new Counter();

            SyncThread syncThread1 = new SyncThread(counter);
            SyncThread syncThread2 = new SyncThread(counter);

            Thread st1 = new Thread(syncThread1, "SyncThread-1");
            Thread st2 = new Thread(syncThread2, "SyncThread-2");

            st1.start();
            st2.start();

            st1.join();
            st2.join();

            System.out.println("Итоговое значение count: " + counter.getCount());


            System.out.println("\n\nНажмите Enter для подолжения...");
            new Scanner(System.in).nextLine();
        }
        else if (taskNumber == 3) {
            // ### Задание 3 ###
            System.out.println("\n\n### 3 Здание ###");
            System.out.println("!!!По завершению выполнения всех потоков нажмите Enter для подолжения!!!\n");
            BankAccount account = new BankAccount(1000);

            System.out.println("Начальный баланс: " + account.getBalance());

            Thread[] threads = new Thread[3];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new AccountThread(account, 10), "AccountThread-" + (i + 1));
            }

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            System.out.println("Итоговый баланс: " + account.getBalance());
        }
        else {

            System.out.println("Пака-пака!");
        }
    }
}