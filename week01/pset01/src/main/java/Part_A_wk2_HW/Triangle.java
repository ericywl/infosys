package Part_A_wk2_HW;

import Misc.GeometricObject;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public double getArea() {
        double periHalf = this.getPerimeter() / 2.0;

        return Math.sqrt(periHalf * (periHalf - side1) * (periHalf - side2) * (periHalf - side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side 2 = " + this.side2 +
                " side 3 = " + this.side3;
    }
}
