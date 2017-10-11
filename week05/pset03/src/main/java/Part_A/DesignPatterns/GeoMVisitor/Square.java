package Part_A.DesignPatterns.GeoMVisitor;


public class Square implements Visitable {
    // Your code goes here
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
