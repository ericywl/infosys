package DesignPatterns.GeoMVisitor;

public class Rectangle implements Visitable {
    // Your code goes here
    private int side1;
    private int side2;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public int[] getSides() {
        return new int[]{side1, side2};
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

