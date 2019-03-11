package Lesson16;

public class MaleSocks extends SocksImpl{
    String colour = "black";

    private  String type = "Male";

    public MaleSocks(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MaleSocks{" +
                "colour='" + colour + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
