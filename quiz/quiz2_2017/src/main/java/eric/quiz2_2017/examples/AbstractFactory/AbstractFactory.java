package eric.quiz2_2017.examples.AbstractFactory;

public abstract class AbstractFactory {
    abstract Component getComponent (String component);
    abstract Board getBoard(String board);
}
