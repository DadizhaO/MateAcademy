package HM03.OOP_abstract;

public class Player1 extends PlayAbs {
    public Player1(double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println(song);
    }
}
