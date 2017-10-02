package Part_A_wk1_cohort;

public class Fibonacci {
    public static String fibonacci() {
        int fibonacciNum1 = 0;
        int fibonacciNum2 = 1;
        int tempNum;
        String result = "0";

        for (int i = 0; i < 19; i++) {
            result = result + ", " + String.valueOf(fibonacciNum2);
            tempNum = fibonacciNum1;
            fibonacciNum1 = fibonacciNum2;
            fibonacciNum2 += tempNum;
        }

        return result;
    }
}
