package eric.quiz2_2017.examples.AbstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType == null) return null;

        if (factoryType.equalsIgnoreCase("COMPONENT")) {
            return new ComponentFactory();
        }

        if (factoryType.equalsIgnoreCase("BOARD")) {
            return new BoardFactory();
        }

        return null;
    }
}
