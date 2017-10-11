package Part_A.DesignPatterns.TrafficAlert;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void changeCondition (String S);
}
