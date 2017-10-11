package Part_A.DesignPatterns.MessageBoard;

public interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}
