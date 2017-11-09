package eric.quiz2_2017.examples.State;

public class StartState implements State {
    public void doAction(Context context) {
        context.setState(new StopState());
    }

    @Override
    public String toString() {
        return("Start State");
    }
}
