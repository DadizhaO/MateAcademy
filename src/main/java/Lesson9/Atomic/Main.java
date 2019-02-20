package Lesson9.Atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        AtomicInteger atomic = new AtomicInteger();


        executor.execute(new Thread(new CountThread(atomic, "1")));
        executor.execute(new Thread(new CountThread(atomic, "1")));
        executor.execute(new Thread(new CountThread(atomic, "1")));

        executor.shutdown();
    }
}
