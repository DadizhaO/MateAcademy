package HM20.adapterPattern;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");

        player = new FormatAdapter(new Cassette());
        player.play("cassette");

    }
}
