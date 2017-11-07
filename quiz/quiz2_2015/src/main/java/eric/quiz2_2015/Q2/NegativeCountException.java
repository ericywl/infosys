package eric.quiz2_2015.Q2;


public class NegativeCountException extends Exception {
    private int count = 0;

    public NegativeCountException() {

    }

    public NegativeCountException(String message) {
        super(message);
    }

    public void addPerson() {
        count++;
    }

    public void removePerson() throws NegativeCountException {
        if (count <= 0)
            throw new NegativeCountException("Cannot remove a person.");

        count--;
    }

    public int getCount() {
        return count;
    }
}
