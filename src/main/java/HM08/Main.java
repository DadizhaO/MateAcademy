package HM08;


import java.io.BufferedReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Animal> queue = new ArrayBlockingQueue<>(6);

        Aibolit aibolit = new Aibolit(queue, 2000);
        Clinic clinic = new Clinic(queue);

        new Thread(aibolit).start();
        new Thread(clinic).start();

    }
}
