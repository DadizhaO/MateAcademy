package Lesson16;

public class MakeSocksZhytomyr extends Factory {
   Socks createSocks(String type){
        Socks socks;
        if (("Female").equals(type)) return socks = new FemaleSocks("Female");
        else if (("Male").equals(type)) return socks = new MaleSocks("Male");
        else if (("Kids").equals(type)) return socks = new KidsSocks();
        else if (("Zhytomyr").equals(type)) return socks = new ZhytomyrSocks();
        else return socks = new SocksImpl();
    }
}
