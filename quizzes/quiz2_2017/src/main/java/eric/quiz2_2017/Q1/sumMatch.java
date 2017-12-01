package eric.quiz2_2017.Q1;

public class sumMatch {
    public static void main(String[] args) {
        System.out.println("sum Match program!");
        Integer arr[] = {5, 2, 3};
        for (int i = 1; i <= 10; i++) {
            System.out.println("i: " + i + " Result: " + match(0, arr, i));
        }
    }


    public static boolean match(Integer k, Integer[] a, int target) {
        if (target == 0) return true;
        if (k == a.length) return false;

        for (int i = k; i < a.length; i++) {
            if (a[i] == target) return true;
        }

        int newTarget = target - a[k];
        if (newTarget >= 0)
            return match(k + 1, a, newTarget);

        return match(k + 1, a, target);
    }


}
