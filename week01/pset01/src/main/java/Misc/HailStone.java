package Misc;

import java.util.ArrayList;

public class HailStone {
    public static ArrayList<Integer> computeHailStone(int n) {
        ArrayList<Integer> hailStoneArray = new ArrayList<>();
        hailStoneArray.add(n);

        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3*n + 1;
            }

            hailStoneArray.add(n);
        }

        return hailStoneArray;
    }

    public static void main(String[] args) {
        System.out.println(computeHailStone(11));
    }
}
