package DesignPatterns.AbstractFactory;

public class Capacitor implements Component {
    @Override
    public void place () {
        System.out.println("In Capacitor::place() method.");
    }
}
