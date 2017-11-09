package eric.quiz2_2017.examples.State;

public class Context {
    private State state;

    public Context() {
        state = new StopState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void doAction() {
        state.doAction(this);
    }

    @Override
    public String toString() {
        return "Player is currently in " + state;
    }
}
