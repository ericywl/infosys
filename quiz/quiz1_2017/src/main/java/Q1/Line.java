package Q1;

public class Line implements Comparable<Line> {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line() {
        this(0, 0, 1, 1);
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double computeSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    public double computeLength() {
        double yDiff = y2 - y1;
        double xDiff = x2 - x1;

        return Math.sqrt(Math.pow(yDiff, 2) + Math.pow(xDiff, 2));
    }

    @Override
    public String toString() {
        return "Line:(" + x1 + "," + y1 + ");(" + x2 + "," + y2 + ")";
    }

    @Override
    public int compareTo(Line o) {
        if (this.computeLength() > o.computeLength()) {
            return 1;
        } else if (this.computeLength() < o.computeLength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
