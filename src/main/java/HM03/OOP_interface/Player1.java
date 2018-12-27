package HM03.OOP_interface;

public class Player1 implements PlaySong{

    private final double price = 23;

    public double getPrice() {
        return price;
    }

    @Override
    public void playSong() {
        System.out.println(song);
    }
}
