package HM08;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

public class Clinic implements Runnable {

    private BlockingQueue<Animal> animals;
    static volatile boolean close = false;
    private LocalDateTime timeToClose = LocalDate.now().atTime(18, 0); //For tests you need to change the time


    public Clinic(BlockingQueue<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public void run() {
        while (!close) {
            for (int i = 0; i < 2; i++) {
                try {
                    Animal cat = new Cat("" + i);
                    Animal dog = new Dog("" + i);
                    animals.put(cat);
                    animals.put(dog);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (LocalDateTime.now().isAfter(timeToClose)) {
                toClose();
            }
        }
    }

    public void toClose() {
        close = true;
    }

}
