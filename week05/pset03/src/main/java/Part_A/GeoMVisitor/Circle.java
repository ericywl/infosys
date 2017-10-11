package Part_A.GeoMVisitor;
import java.lang.Math;


public class Circle implements Visitable {
     // Your code goes here
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
