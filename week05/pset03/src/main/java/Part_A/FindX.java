package Part_A;

public class FindX {
    private int visitNumber = 0;

    public FindX() {
        visitNumber++;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public int findX(int x, int[] A) {
        visitNumber++;
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] == x) return i;
        }

        return -1;
    }
}
