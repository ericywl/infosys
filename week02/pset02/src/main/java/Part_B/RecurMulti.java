package Part_B;
// Cohort Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

public class RecurMulti {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
        System.out.println(multiply(0, 7));
        System.out.println(multiply(4, 0));
        System.out.println(multiply(2, -3));

    }

    public static int multiply(int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        } else if (i < 0 && j > 0) {
            return multiply(i + 1, j) - j;
        } else if (i > 0 && j < 0) {
            return multiply(i, j + 1) - i;
        } else if (i < 0 && j < 0) {
            return multiply(-i, -j);
        }

        return multiply(i - 1, j) + j;
    }

}