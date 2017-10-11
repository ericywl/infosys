package Part_A.StockGrabber;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    // your code goes here
    private ArrayList<Observer> obsList = new ArrayList<>();

    @Override
    public void register(Observer o) {
        obsList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        obsList.remove(o);
    }

    @Override
    public void stockUpdate(String s) {
        for (Observer o : obsList) {
            o.update(s);
        }
    }
}
