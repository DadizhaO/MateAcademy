package Lesson16;

public class KidsSocks extends SocksImpl {
    int size = 25;
    String colour = "striped";

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int setSize(int size) {
        return 0;
    }

    @Override
    public String getColour() {
        return null;
    }

    @Override
    public String setColour(String colour) {
        return null;
    }
}
