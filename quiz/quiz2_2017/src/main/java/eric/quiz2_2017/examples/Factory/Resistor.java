package eric.quiz2_2017.examples.Factory;

public class Resistor implements Component {
    @Override
    public void draw () {
        System.out.println ("In Resistor::draw() method.");
    }
}

