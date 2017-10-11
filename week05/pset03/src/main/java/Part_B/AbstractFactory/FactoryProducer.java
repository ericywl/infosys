package Part_B.AbstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory (String factoryType) {
        if (factoryType == null) return null;
        if (factoryType.equalsIgnoreCase("COMPONENT")) {
            AbstractFactory af;
            af = new ComponentFactory();
            return af; // compiler complains if we do it all in one line
        }
        else if (factoryType.equalsIgnoreCase("BOARD")) {
            AbstractFactory af;
            af = new BoardFactory();
            return af;
        }
        else return null;
    }
}
