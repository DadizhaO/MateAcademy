package HM20.abstractFactoryPattern;

public class OrcCastle implements Castle{

    @Override
    public String getDescription() {
        String description = "Mordor";
        System.out.println(description);
        return description;
    }
}
