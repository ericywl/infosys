package Part_A_wk1_HW;

public class PrimeNumberChecker {
    public static int checkPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
