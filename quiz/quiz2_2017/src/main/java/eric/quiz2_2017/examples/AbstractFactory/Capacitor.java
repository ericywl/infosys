package eric.quiz2_2017.examples.AbstractFactory;

public class Capacitor implements Component {
    @Override
    public void place () {
        System.out.println("In Capacitor::place() method.");
    }
}
