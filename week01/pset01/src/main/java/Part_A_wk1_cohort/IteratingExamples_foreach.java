package Part_A_wk1_cohort;

import java.util.List;

public class IteratingExamples_foreach {
    public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;

        for (int i : integers) {
            sum += i;
        }

        return sum;
    }
}
