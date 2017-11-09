package eric.quiz2_2017.examples.AbstractFactory;

public class BreadBoard implements Board {
    @Override
    public void configure () {
        System.out.println ("In BreadBoard::configure() method.");
    }
}
