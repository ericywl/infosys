package Part_A.DesignPatterns.Factory;

public class Diode implements Component {
    @Override
    public void draw (){
        System.out.println ("In Diode::draw() method.");
    }
}
