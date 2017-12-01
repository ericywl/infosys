package eric.quiz3_2015.Q6;


import java.util.ArrayList;
import java.util.Arrays;

public class TestStronglyConnected {
    public static void main(String[] args) {
        int nodeCount = 4;
        int linkCount = 3;
        ArrayList<Integer> listOfLink = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3));

        boolean b = StronglyConnected.isStronglyConnected(nodeCount, linkCount, listOfLink);
        System.out.println(b);

        int nodeCount2 = 5;
        int linkCount2 = 5;
        ArrayList<Integer> listOfLink2 =
                new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4, 4, 0));

        boolean b2 = StronglyConnected.isStronglyConnected(nodeCount2, linkCount2, listOfLink2);
        System.out.println(b2);

    }
}

