package Part_A.DesignPatterns.GeoMVisitor;

import java.util.ArrayList;

public class GeometryVisitor {
    public static void main (String[] args) {
        System.out.println("Hello World! Testing Geometry Visitor.");

        ArrayList<Visitable> shapes = new ArrayList<Visitable>();
        AreaVisitor area = new AreaVisitor();
        shapes.add(new Circle(10));
        shapes.add(new Square(4));
        shapes.add(new Rectangle(2, 4));

        for (Visitable s : shapes) {
            s.accept(area);
        }

        System.out.printf("%.4f%n",  area.getTotalArea());

        PerimeterVisitor perimeter = new PerimeterVisitor();
        for (Visitable s : shapes) {
            s.accept(perimeter);
        }

        System.out.printf("%.4f%n", perimeter.getTotalPerimeter());

    }

}

