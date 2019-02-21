package HM20.abstractFactoryPattern;

import static HM20.abstractFactoryPattern.MakeFactory.KingdomType.ELF;
import static HM20.abstractFactoryPattern.MakeFactory.KingdomType.ORC;

public class Main {
    public static void main(String[] args) {

        KingdomFactory kingdom = MakeFactory.makeFactory(ELF);
        kingdom.createCastle().getDescription();
        kingdom.createArmy().getDescription();

        KingdomFactory kingdom2 = MakeFactory.makeFactory(ORC);
        kingdom2.createCastle().getDescription();
        kingdom2.createArmy().getDescription();

    }

}
