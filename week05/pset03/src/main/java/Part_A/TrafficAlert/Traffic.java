package Part_A.TrafficAlert;

import java.util.ArrayList;

public class Traffic implements Subject {
    private ArrayList<Observer> roadUsers = new ArrayList<>();

    // Your code goes here
    @Override
    public void register(Observer o) {
        roadUsers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        roadUsers.remove(o);
    }

    @Override
    public void changeCondition(String s) {
        for (Observer roadUser : roadUsers) {
            roadUser.update(s);
        }
    }
}