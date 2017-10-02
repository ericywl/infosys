package Misc;

import Part_A_wk2_HW.Pset1;

public class TestPset1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Pset1.isAllCharacterUnique("abcdefghijklmnopqrstuvABC"));
        System.out.println(Pset1.isAllCharacterUnique("abcdefgghijklmnopqrstuvABC"));
        System.out.println(Pset1.isPermutation("@ab", "a@b"));
        System.out.println(Pset1.isPermutation("abcd", "bcdA"));

    }
}

