package Part_A.AbstractFactory;

public class VeroBoard implements Board {
    @Override
    public void configure() {
        System.out.println("In VeroBoard::configure() method");
    }
}
