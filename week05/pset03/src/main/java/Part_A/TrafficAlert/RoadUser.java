package Part_A.TrafficAlert;

public class RoadUser implements Observer {
    private String name;

    // Your code goes here
    public RoadUser(String name, Traffic traffic) {
        this.name = name;
        traffic.register(this);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " receives alert: " + message);
    }
}
