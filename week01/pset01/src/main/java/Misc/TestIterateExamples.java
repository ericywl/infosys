package Misc;

import java.util.Arrays;
import java.util.List;

import Part_A_wk1_cohort.IteratingExamples_Iterator;
import Part_A_wk1_cohort.IteratingExamples_foreach;

public class TestIterateExamples {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(IteratingExamples_foreach.Act2ForEach(list));
        System.out.println(IteratingExamples_Iterator.Act2Iterator(list));

    }
}
