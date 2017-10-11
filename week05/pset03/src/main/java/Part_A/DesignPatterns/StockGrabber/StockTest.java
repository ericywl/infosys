package Part_A.DesignPatterns.StockGrabber;

public class StockTest {
    // Your code goes here
    public static void main(String[] args) {
        StockGrabber IBM = new StockGrabber();
        StockObserver scott = new StockObserver(IBM, "scott");
        StockObserver jim = new StockObserver(IBM, "jim");
        IBM.stockUpdate("IBM going up by $0.05");
        StockObserver jeremy = new StockObserver(IBM, "jeremy");
        IBM.stockUpdate("IBM is going down by $0.03");
    }
}
