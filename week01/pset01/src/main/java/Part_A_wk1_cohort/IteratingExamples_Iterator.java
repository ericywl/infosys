package Part_A_wk1_cohort;

import java.util.Iterator;
import java.util.List;

public class IteratingExamples_Iterator {
    public static int Act2Iterator(List<Integer> integers) {
        Iterator<Integer> integerIterator= integers.iterator();
        int sum = 0;

        while (integerIterator.hasNext()) {
            sum += integerIterator.next();
        }

        return sum;
    }
}
