package Part_A_wk2_HW;

import java.util.Arrays;

public class Pset1 {
    public static boolean isAllCharacterUnique(String sIn) {
        boolean[] asciiArray = new boolean[128];

        for (int i = 0; i < sIn.length(); i++) {
            int asciiValue = sIn.charAt(i);

            if (asciiArray[asciiValue]) {
                return false;
            } else {
                asciiArray[asciiValue] = true;
            }
        }

        return true;
    }

    public static boolean isPermutation(String sIn1, String sIn2) {
        if (sIn1.length() != sIn2.length()) {
            return false;
        }

        int[] asciiArray1 = new int[128];
        int[] asciiArray2 = new int[128];

        for (int i = 0; i < sIn1.length(); i++) {
            int asciiValue1 = sIn1.charAt(i);

            asciiArray1[asciiValue1] += 1;
        }

        for (int j = 0; j < sIn2.length(); j++) {
            int asciiValue2 = sIn2.charAt(j);

            asciiArray2[asciiValue2] += 1;
        }

        return Arrays.equals(asciiArray1, asciiArray2);
    }
}
