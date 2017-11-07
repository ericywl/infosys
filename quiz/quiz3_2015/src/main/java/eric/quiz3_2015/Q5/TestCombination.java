package eric.quiz3_2015.Q5;


public class TestCombination {
    public static void main(String[] args) {
        String[][] data = {{"A", "B", "C"}, {"1"}, {"XX", "YY"}};
        String[] oneline = new String[data.length];
        System.out.println(Combination.recurCombination(data, oneline, 0));
    }
}
