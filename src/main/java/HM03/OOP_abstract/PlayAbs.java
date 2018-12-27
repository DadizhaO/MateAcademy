package HM03.OOP_abstract;


public abstract class PlayAbs implements PlaySong {

    final double price;
    final String song = "song1";

    public PlayAbs(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public abstract void playSong();

}
