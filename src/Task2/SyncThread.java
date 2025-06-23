package Task2;

public class SyncThread implements Runnable {
    private Counter counter;

    public SyncThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " запускается.");
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName() + " завершен.");
    }
}
