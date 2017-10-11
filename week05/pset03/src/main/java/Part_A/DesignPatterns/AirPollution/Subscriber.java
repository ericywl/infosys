package Part_A.DesignPatterns.AirPollution;

class Subscriber implements Observer {
    // Your code goes here
    private String name;

    public Subscriber(String name, AirPollutionAlert alert) {
        this.name = name;
        alert.register(this);
    }

    @Override
    public void update(double airPollutionIndex) {
        System.out.println(name + " received notification: " + airPollutionIndex);
    }
}

