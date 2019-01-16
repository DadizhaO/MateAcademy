package HM09;

public class ThreadResource {

    private int value;

    public ThreadResource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int incrementValue() {
        return value++;
    }


}
