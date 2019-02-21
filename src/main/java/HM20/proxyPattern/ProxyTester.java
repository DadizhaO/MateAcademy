package HM20.proxyPattern;

public class ProxyTester implements TesterInterface {
    private Tester tester;

    public ProxyTester(Tester tester) {
        this.tester = tester;
    }

    @Override
    public void testCode() {
        if (writeDocumentation()) {
            tester.testCode();
            System.out.println("Also I write documentation");
        } else tester.testCode();
    }

    @Override
    public boolean writeDocumentation() {
        return tester.writeDocumentation();
    }
}
