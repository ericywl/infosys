package eric.quiz2_2017.examples.AbstractFactory;

public class PrintedCctBoard implements Board {
    @Override
    public void configure() {
        System.out.println("In PrintCctBoard::configure() method.");
    }
}
