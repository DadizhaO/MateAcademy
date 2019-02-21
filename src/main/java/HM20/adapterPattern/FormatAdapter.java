package HM20.adapterPattern;

public class FormatAdapter implements MediaPlayer {
    private Cassette casset;

    public FormatAdapter(Cassette casset) {
        this.casset = casset;
    }


    @Override
    public void play(String filename) {

        System.out.println("Adapter: ");
        casset.playFile(filename);
    }
}
