package Part_A;

public class FindX {
    private int visitnumber = 0;

    public FindX() {
        visitnumber++;
    }

    public int getVisitNumber() {
        return visitnumber;
    }

    public int findX(int x, int[] A) {
        visitnumber++;
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] == x) return i;
        }

        return -1;
    }
}
