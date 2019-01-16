package HM09;


import java.util.concurrent.Callable;

public class CountThread implements Callable {
    private String name;
    private ThreadResource resource;

    public CountThread(ThreadResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            resource.incrementValue();
            Thread.sleep(100);
        }
        return resource.getValue();
    }

}



