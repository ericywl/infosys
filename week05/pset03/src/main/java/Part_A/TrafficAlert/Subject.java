package Part_A.TrafficAlert;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void changeCondition (String S);
}
