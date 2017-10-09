package Part_B;
// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
    public static void main(String[] args) {
        int number = -54;
        System.out.println(sumDigits(number));
    }

    public static int sumDigits(int number) {
        if (number == 0) {
            return 0;
        }

        if (number < -9) {
            return -number % 10 + sumDigits(number / 10);
        }

        return number % 10 + sumDigits(number / 10);

    }
}
