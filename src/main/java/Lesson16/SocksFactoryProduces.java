package Lesson16;

public class SocksFactoryProduces {
    public static Factory createFactory (String factory){
        if ("kiev".equals(factory)) return new MakeSocksKiev();
        else if ("zhytomyr".equals(factory)) return new MakeSocksZhytomyr();
        else return new MakeSocksKiev();

    }
}
