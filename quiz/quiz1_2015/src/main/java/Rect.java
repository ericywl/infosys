public class Rect {
    private double width;
    private double height;

    public Rect() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle: width = " + width + " height = " + height;
    }

    public static void main(String[] args) {
        TestRect();
    }

    public static void TestRect() {
        Rect r1 = new Rect();
        System.out.println(r1);
        System.out.println(r1.getArea());

        Rect r2 = new Rect(2, 12);
        System.out.println(r2);
        System.out.println(r2.getArea());
    }
}
