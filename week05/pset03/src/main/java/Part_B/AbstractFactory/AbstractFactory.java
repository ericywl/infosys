package Part_B.AbstractFactory;

public abstract class AbstractFactory {
    abstract Component getComponent (String component);
    abstract Board getBoard(String board);
}
