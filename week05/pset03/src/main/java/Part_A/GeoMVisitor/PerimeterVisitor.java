package Part_A.GeoMVisitor;

public class PerimeterVisitor implements Visitor {
     // Your code goes here
    private double totalPerimeter;

    public double getTotalPerimeter() {
        return totalPerimeter;
    }

    @Override
    public void visit(Circle c) {
        totalPerimeter += 2 * Math.PI * c.getRadius();
    }

    @Override
    public void visit(Square s) {
        totalPerimeter += 4 * s.getSide();
    }

    @Override
    public void visit(Rectangle r) {
        totalPerimeter += 2 * r.getSides()[0] + 2* r.getSides()[1];
    }
}

