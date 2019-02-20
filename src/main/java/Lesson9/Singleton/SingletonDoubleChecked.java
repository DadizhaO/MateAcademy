package Lesson9.Singleton;

public class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    public static SingletonDoubleChecked getInstance() {
        SingletonDoubleChecked localInstance = instance;

        if (localInstance == null) {
            synchronized (SingletonDoubleChecked.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonDoubleChecked();
                }
            }
        }
        return localInstance;
    }
}
