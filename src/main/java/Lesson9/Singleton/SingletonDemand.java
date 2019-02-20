package Lesson9.Singleton;

public class SingletonDemand {

    private SingletonDemand(){}

    private static class SingletonHolder{
        private final static SingletonDemand instance = new SingletonDemand();
    }

    private static SingletonDemand getInstance(){
        return SingletonHolder.instance;
    }
}
