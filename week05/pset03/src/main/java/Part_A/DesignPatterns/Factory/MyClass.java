package Part_A.DesignPatterns.Factory;

public class MyClass {
    public static void main (String[] args) {
        // create a factory for components
        ComponentFactory cf = new ComponentFactory();

        // get a resistor
        Component C1 = cf.getComponent("RESISTOR");

        //get a capacitor
        Component C2 = cf.getComponent("CAPACITOR");

        // get a diode
        Component C3 = cf.getComponent("DIODE");

        //now draw them
        C1.draw();
        C2.draw();
        C3.draw();
    }
}
