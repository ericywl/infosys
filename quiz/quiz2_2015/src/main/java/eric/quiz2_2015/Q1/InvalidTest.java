package eric.quiz2_2015.Q1;


public class InvalidTest extends Exception {
    public InvalidTest() {

    }

    public InvalidTest(String message) {
        super(message);
    }

    public void testScores(double[] s) throws InvalidTest{
        for (double score : s) {
            if (score > 100 || score < 0) {
                String msgStart = "Score negative or bigger than 100: ";
                throw new InvalidTest(msgStart + String.valueOf(score));
            }
        }
    }
}
