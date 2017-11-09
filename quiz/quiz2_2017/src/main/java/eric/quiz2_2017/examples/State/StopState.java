package eric.quiz2_2017.examples.State;

public class StopState implements State {
    public void doAction(Context context) {
        context.setState(new StartState());
    }

    @Override
    public String toString() {
        return("Stop State");
    }
}