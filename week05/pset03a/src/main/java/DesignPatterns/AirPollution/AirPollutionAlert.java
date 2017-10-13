package DesignPatterns.AirPollution;

import java.util.ArrayList;

class AirPollutionAlert implements Subject {
     // Your code goes here
    private int index;
    private ArrayList<Observer> observers = new ArrayList<>();

    public void setAirPollutionIndex(int index) {
        if (index > 100) {
            this.index = index;
            notifyObservers();
        }
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(index);
        }
    }
}




