package HM20.abstractFactoryPattern;

public class OrcArmy implements Army {

    @Override
    public String getDescription() {
        String description = "Army of orcs";
        System.out.println(description);
        return description;
    }
}
