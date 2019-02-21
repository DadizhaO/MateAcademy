package HM20.proxyPattern;

public class Tester implements TesterInterface {
    private String name;
    private boolean documentation;


    public Tester(String name, boolean documentation) {
        this.name = name;
        this.documentation = documentation;
    }

    @Override
    public void testCode() {
        System.out.println("I Tester " + name + ", I test code");
    }

    @Override
    public boolean writeDocumentation() {
        return documentation;
    }
}
