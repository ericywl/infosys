package Part_A.DesignPatterns.AirPollution;

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
