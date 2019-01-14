package HM08;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void doVoice() {
        System.out.println("Gav");
    }
}
