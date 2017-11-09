package eric.quiz2_2017.examples.Observor;

public class Subscriber implements Observer {
    private int observerId;
    private static int observerIdTrack = 0;

    public Subscriber(Subject subject) {
        subject.register(this);  // register itself into the list of observers

        observerId = observerIdTrack++;
    }

    @Override
    public void update(String message) {
        System.out.println("subscriber " + observerId + " got notified: " + message);
    }


}
