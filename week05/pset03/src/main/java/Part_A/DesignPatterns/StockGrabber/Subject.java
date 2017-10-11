package Part_A.DesignPatterns.StockGrabber;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void stockUpdate(String S);
}
