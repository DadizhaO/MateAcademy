package Lesson9.Semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6);
        Resurse resurse = new Resurse(0);

        new Thread(new CountThread(resurse, semaphore, "CountThread 1")).start();
        new Thread(new CountThread(resurse, semaphore, "CountThread 2")).start();
        new Thread(new CountThread(resurse, semaphore, "CountThread 3")).start();
        new Thread(new CountThread(resurse, semaphore, "CountThread 3")).start();
        new Thread(new CountThread(resurse, semaphore, "CountThread 3")).start();
        new Thread(new CountThread(resurse, semaphore, "CountThread 3")).start();
    }
}
