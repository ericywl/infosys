package Misc;

import Part_A_wk1_HW.MyRectangle2D;

public class TestMyRectangle2D {
    public static void main(String[] args) {
        MyRectangle2D originalRect = new MyRectangle2D(0, 0, 3, 2);
        MyRectangle2D comparedRect1 = new MyRectangle2D();
        MyRectangle2D comparedRect2 = new MyRectangle2D(1, 1, 4, 2);
        MyRectangle2D comparedRect3 = new MyRectangle2D(4, 4, 1, 2);

        System.out.println("Height: " + originalRect.getHeight());
        System.out.println("Width: " + originalRect.getWidth());
        System.out.println("Perimeter: " + originalRect.getPerimeter());
        System.out.println("Area: " + originalRect.getArea());
        System.out.println("");

        System.out.println("Contains coordinate: ");
        System.out.println("(0, 2): " + originalRect.contains(0, 2));
        System.out.println("(-1.4, -0.9): " + originalRect.contains(1.4, 0.9));
        System.out.println("");

        System.out.println("comparedRect1: ");
        System.out.println("overlaps: " + originalRect.overlaps(comparedRect1));
        System.out.println("contains: " + originalRect.contains(comparedRect1));
        System.out.println("");

        System.out.println("comparedRect2: ");
        System.out.println("overlaps: " + originalRect.overlaps(comparedRect2));
        System.out.println("contains: " + originalRect.contains(comparedRect2));
        System.out.println("");

        System.out.println("comparedRect3: ");
        System.out.println("overlaps: " + originalRect.overlaps(comparedRect3));
        System.out.println("contains: " + originalRect.contains(comparedRect3));
    }
}
