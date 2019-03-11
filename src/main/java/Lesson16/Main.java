package Lesson16;

public class Main {


    public static void main(String[] args) {


        Factory factory = SocksFactoryProduces.createFactory("kiev");
        Socks socks = factory.createSocks("Sport");
        System.out.println(socks);


     /*   Socks male = MakeSocksZhytomyr.createSocks("Male");
        System.out.println(male);
        Socks famale = MakeSocksZhytomyr.createSocks("Female");
        System.out.println(famale);*/
    }


}
