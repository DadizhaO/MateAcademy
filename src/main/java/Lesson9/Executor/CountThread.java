package Lesson9.Executor;

public class CountThread implements Runnable {
    private Resurse res;
    private String name;

    public CountThread(Resurse res, String name) {
        this.res = res;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                res.incrementValue();
                System.out.println(res.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
