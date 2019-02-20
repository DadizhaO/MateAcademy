package Lesson9.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Resurse resurse = new Resurse(0);

        ExecutorService executor1 = Executors.newSingleThreadExecutor();

        executor1.execute(new Thread(new CountThread(resurse, "3")));
        executor1.execute(new Thread(new CountThread(resurse, "3")));
        executor1.execute(new Thread(new CountThread(resurse, "3")));

    }
}
