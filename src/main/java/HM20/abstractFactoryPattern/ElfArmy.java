package HM20.abstractFactoryPattern;

public class ElfArmy implements Army {

    @Override
    public String getDescription() {
        String description = "Army of Elves";
        System.out.println(description);
        return description;
    }
}
