package Part_A.StockGrabber;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void stockUpdate(String S);
}
