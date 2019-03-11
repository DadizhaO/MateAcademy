package Lesson16;

public class MakeSocksKiev extends Factory {

     Socks createSocks(String type){
        Socks socks;
        if (("Sport").equals(type)) return socks = new SportSocks();

        else return socks = new SocksImpl();
    }
}
