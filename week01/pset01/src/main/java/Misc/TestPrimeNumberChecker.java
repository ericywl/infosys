package Misc;


import static Part_A_wk1_HW.PrimeNumberChecker.checkPrime;

public class TestPrimeNumberChecker {
    public static void main(String[] args) {
        System.out.println("4: " + checkPrime(4));
        System.out.println("7: " + checkPrime(7));
        System.out.println("14: " + checkPrime(14));
        System.out.println("23: " + checkPrime(23));
        System.out.println("99: " + checkPrime(99));
    }
}
