package eric.quiz2_2017.examples.AbstractFactory;

public class Diode implements Component {
    @Override
    public void place (){
        System.out.println("In Diode::place() method.");
    }
}
