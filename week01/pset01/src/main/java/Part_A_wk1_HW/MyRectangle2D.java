package Part_A_wk1_HW;


public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public double getY() {
        return this.y;
    }

    public void setWidth(double newWidth) {
        this.width = newWidth;
    }

    public double getWidth() {
        return this.width;
    }

    public void setHeight(double newHeight) {
        this.height = newHeight;
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    public boolean contains(double x, double y) {
        boolean xInRange = (this.x - (this.width / 2) < x && x < this.x + (this.width / 2));
        boolean yInRange = (this.y - (this.height / 2) < y && y < this.y + (this.height / 2));

        return (xInRange && yInRange);
    }

    public boolean contains(MyRectangle2D r) {
        double rLeftX = r.x - (r.width / 2);
        double rRightX = r.x + (r.width / 2);
        double rBottomY = r.y - (r.height / 2);
        double rTopY = r.y + (r.height / 2);

        return (this.contains(rLeftX, rBottomY) && this.contains(rRightX, rTopY));
    }

    public boolean overlaps(MyRectangle2D r) {
        double rLeftX = r.x - (r.width / 2);
        double rRightX = r.x + (r.width / 2);
        double rBottomY = r.y - (r.height / 2);
        double rTopY = r.y + (r.height / 2);

        return (this.contains(rLeftX, rBottomY)
                || this.contains(rLeftX, rTopY)
                || this.contains(rRightX, rBottomY)
                || this.contains(rRightX, rTopY));
    }
}
