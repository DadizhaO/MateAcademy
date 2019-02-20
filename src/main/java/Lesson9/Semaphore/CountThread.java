package Lesson9.Semaphore;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{

    private Resurse res;
    private Semaphore sem;
    private String name;

    public CountThread(Resurse res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            for (int i = 0; i < 5; i++) {
                res.incrementValue();
                System.out.println( res.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();

    }
}
