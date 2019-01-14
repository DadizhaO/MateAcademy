package HM08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Aibolit implements Runnable {

    private BlockingQueue<Animal> animals;
    private int restTime;

    public Aibolit(BlockingQueue<Animal> animals, int restTime) {
        this.animals = animals;
        this.restTime = restTime;
    }

    @Override
    public void run() {
        while (!Clinic.close) {
            toGetPatient();
            try {
                Thread.sleep(restTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toGetPatient() {
        try {
            Animal animal = animals.take();
            animal.doVoice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
