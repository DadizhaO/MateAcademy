package Lesson9.Atomic;


import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Runnable {

    private String name;
    private AtomicInteger value;

    public CountThread(AtomicInteger value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                incrementValue();
                System.out.println(getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public AtomicInteger getValue() {
        return value;
    }

    public void incrementValue() {
        value.incrementAndGet();
    }
}
