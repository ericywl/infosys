package eric.quiz2_2017.examples.Factory;

public class Capacitor implements Component {
    @Override
    public void draw () {
        System.out.println("In Capacitor:draw() method.");
    }
}
