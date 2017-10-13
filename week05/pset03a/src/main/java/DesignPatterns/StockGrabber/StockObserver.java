package DesignPatterns.StockGrabber;

 
public class StockObserver implements Observer {
     // Your code goes here
    private String name;

    public StockObserver(StockGrabber stockGrabber, String name) {
        this.name = name;
        stockGrabber.register(this);
    }

    @Override
    public void update(String message) {
        System.out.println(name + ": Message received: " + message);
    }
}
