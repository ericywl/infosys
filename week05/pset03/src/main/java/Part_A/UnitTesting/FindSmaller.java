package Part_A.UnitTesting;

public class FindSmaller {
    public int findSmaller(int x, int[] a) {
        int len = a.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (a[i] < x) count++;
        }

        return count;
    }
}
