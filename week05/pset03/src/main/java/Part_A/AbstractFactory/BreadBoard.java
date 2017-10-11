package Part_A.AbstractFactory;

public class BreadBoard implements Board {
    @Override
    public void configure () {
        System.out.println ("In BreadBoard::configure() method.");
    }
}
