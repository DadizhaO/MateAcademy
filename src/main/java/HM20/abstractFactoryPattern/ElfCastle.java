package HM20.abstractFactoryPattern;

public class ElfCastle implements Castle {

    @Override
    public String getDescription() {
        String description = "Rivendell";
        System.out.println(description);
        return description;
    }
}
