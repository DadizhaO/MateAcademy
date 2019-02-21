package HM20.proxyPattern;

public class Main {
    public static void main(String[] args) {
        Tester tester1 = new Tester("Ivan",true);


        ProxyTester tester2 = new ProxyTester(tester1);
        tester2.testCode();
    }
}
