package Part_B;
// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
    public static void main(String[] args) {
        int number = 54321;
        System.out.println(sumDigits(number));
    }

    public static int sumDigits(int number) {
        return number == 0 ? 0 : number % 10 + sumDigits(number / 10);
        // this is equivalent to the statement below

        /*
        if (number == 0) {
            return 0;
        } else {
            return number % 10 + sumDigits(number / 10);
        }
        */
    }
}
