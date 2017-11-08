package eric.quiz3_2015.Q6;


import java.util.ArrayList;
import java.util.Arrays;

public class TestStronglyConnected {
    public static void main(String[] args) {
        int nodecount = 4;
        int linkcount = 3;
        ArrayList<Integer> listOfLink = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3));
        System.out.println(StronglyConnected.isStronglyConnected(nodecount, linkcount, listOfLink));

        int nodecount2 = 5;
        int linkcount2 = 5;
        ArrayList<Integer> listOfLink2 =
                new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 3, 3, 4, 4, 0));
        System.out.println(StronglyConnected.isStronglyConnected(nodecount2, linkcount2, listOfLink2));

    }
}

