package Lesson16;

public class SocksImpl implements Socks{
    private int size;
    private String colour;


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int setSize(int size) {
        return this.size = size;
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public String setColour(String colour) {
        return this.colour = colour;
    }
}
