package Part_A.DesignPatterns.AbstractFactory;

public class MyClass {
    public static void main (String[] args) {
        //first create a factory for producing boards
        AbstractFactory bf = FactoryProducer.getFactory("BOARD");

        // now get a breadboard from the factory
        Board b1 = bf.getBoard("BREADBOARD");
        // now get a veroboard
        Board b2 = bf.getBoard("VEROBOARD");
        // now get a PCB
        Board b3 = bf.getBoard("PRINTEDCIRCUITBOARD");

        // now configure them
        b1.configure();
        b2.configure();
        b3.configure();

        // next create a component factory
        AbstractFactory cf = FactoryProducer.getFactory("COMPONENT");

        // now get a resistor from the factory
        Component c1 = cf.getComponent("RESISTOR");
        // now get a capacitor
        Component c2 = cf.getComponent("CAPACITOR");
        // now get a diode
        Component c3 = cf.getComponent("DIODE");

        // now place them
        c1.place();
        c2.place();
        c3.place();
    }
}


