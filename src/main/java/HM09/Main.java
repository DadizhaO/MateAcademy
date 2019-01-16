package HM09;


import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadResource resource = new ThreadResource(0);

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable callable2 = new CountThread(resource, "name");
        Callable callable3 = new CountThread(resource, "name");
        Callable callable4 = new CountThread(resource, "name");

        Future future = executor.submit(callable2);
        Future future2 = executor.submit(callable3);
        Future future3 = executor.submit(callable4);
        System.out.println(future.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        executor.shutdown();
    }
}
