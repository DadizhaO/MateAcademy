package HM20.adapterPattern;

public class MP3 implements MediaPlayer {
    @Override
    public void play(String filename) {
        System.out.println("Playing MP3 " + filename);
    }
}
