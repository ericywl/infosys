package eric.quiz2_2017.examples.AbstractFactory;

public class Resistor implements Component {
    @Override
    public void place () {
        System.out.println("In Resistor::place() method.");
    }
}
