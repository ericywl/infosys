package DesignPatterns.Factory;

public class Capacitor implements Component {
    @Override
    public void draw () {
        System.out.println("In Capacitor:draw() method.");
    }
}
