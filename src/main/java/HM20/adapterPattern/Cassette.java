package HM20.adapterPattern;

public class Cassette implements RecordPlayer {
    @Override
    public void playFile(String filename) {
        System.out.println("Playing cassette " + filename);
    }
}
