package eric.quiz3_2015.Q2;


public class Fibonacci {
    public static int recurFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return recurFibonacci(n - 1) + recurFibonacci(n - 2);
    }
}
