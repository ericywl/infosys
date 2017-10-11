package Part_B.AbstractFactory;

public class BoardFactory extends AbstractFactory {

    @Override
    public Board getBoard (String board) {
        if (board == null) return null;
        if (board.equalsIgnoreCase("BREADBOARD")) {
            return new BreadBoard();
        }
        if (board.equalsIgnoreCase("VEROBOARD")) {
            return new VeroBoard();
        }
        if (board.equalsIgnoreCase("PRINTEDCIRCUITBOARD")) {
            return new PrintedCctBoard ();
        }
        else return null;
    }

    @Override
    Component getComponent (String component) {
        return null;
    }
}


