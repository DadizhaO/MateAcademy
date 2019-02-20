package Lesson9.Semaphore;

public class Resurse {
    private int value = 0;


    public Resurse(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void incrementValue() {
        value++;
    }

}
