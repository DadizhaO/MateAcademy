package HM20.abstractFactoryPattern;

public class MakeFactory {

    public enum KingdomType {
        ELF, ORC
    }

    public static KingdomFactory makeFactory(KingdomType type) {
        switch (type) {
            case ELF:
                return new ElfKingdom();
            case ORC:
                return new OrcKingdom();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
