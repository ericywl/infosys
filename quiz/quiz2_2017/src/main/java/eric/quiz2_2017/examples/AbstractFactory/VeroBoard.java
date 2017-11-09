package eric.quiz2_2017.examples.AbstractFactory;

public class VeroBoard implements Board {
    @Override
    public void configure() {
        System.out.println("In VeroBoard::configure() method");
    }
}
