package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeFinishAssignment {
    private static int[] timeArray = new int[3];

    public static void main(String[] args) {
        ArrayList<Integer> listOfAssignment = new ArrayList<>();
        listOfAssignment.add(6);
        listOfAssignment.add(7);
        listOfAssignment.add(8);
        listOfAssignment.add(9);
        listOfAssignment.add(10);

        System.out.println(computeTimeFinish(listOfAssignment));
        // output: 15

    }

    public static int computeTimeFinish(ArrayList<Integer> l) {
        Collections.sort(l);

        for (int i = l.size() - 1; i > -1; i--) {
            timeArray[0] += l.get(i);
            Arrays.sort(timeArray);
            System.out.println(Arrays.toString(timeArray));
        }

        return timeArray[2];
    }
}

