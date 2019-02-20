package Lesson9.Singleton;

public class SingletonTest {
    static private final SingletonTest instance = new SingletonTest();

    private SingletonTest(){}

    public static SingletonTest getInstance(){
        return instance;
    }

}
