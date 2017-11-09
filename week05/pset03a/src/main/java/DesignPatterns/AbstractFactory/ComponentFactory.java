package DesignPatterns.AbstractFactory;

public class ComponentFactory extends AbstractFactory {

    @Override
    public Component getComponent(String componentType) {
        if (componentType == null) return null;

        if (componentType.equalsIgnoreCase("RESISTOR")) {
            return new Resistor();
        }

        if (componentType.equalsIgnoreCase("CAPACITOR")) {
            return new Capacitor();
        }

        if (componentType.equalsIgnoreCase("DIODE")) {
            return new Diode();
        }

        return null;
    }

    @Override
    Board getBoard(String board) {
        return null;
    }
}
