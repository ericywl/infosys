package eric.quiz2_2017.examples.State;

public class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in Start state.");
        context.setState(this);
    }

    public String toString() {
        return("Start State");
    }
}
