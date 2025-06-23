package Task1;

public class MyThread implements Runnable {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
        System.out.println("Создан " + threadName);
    }

    @Override
    public void run() {
        System.out.println(threadName + " запускается.");
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + i);
        }
        System.out.println(threadName + " завершен.");
    }
}
