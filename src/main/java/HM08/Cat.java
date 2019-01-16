package HM08;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void doVoice() {
        System.out.println("Myv");
    }
}
