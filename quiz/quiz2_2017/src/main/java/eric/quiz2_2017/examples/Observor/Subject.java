package eric.quiz2_2017.examples.Observor;

public interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}
