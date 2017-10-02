public class Matrix {
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        for (int indexA = m - 1, indexB = n - 1, i = m + n - 1; i >= 0; i--) {
            if (indexA >= 0 && indexB >= 0) {
                if (A[indexA] > B[indexB]) {
                    A[i] = A[indexA];
                    indexA--;
                } else {
                    A[i] = B[indexB];
                    indexB--;
                }
            } else if (indexB >= 0) {
                A[i] = B[indexB];
                indexB--;
            }
        }
    }

    public static void main(String[] args) {
        int[] f = new int[5];
        f[0] = 1;
        f[1] = 3;
        f[2] = 5;
        int[] g = {2, 3};

        mergeSortedArray(f, 3, g, 2);

        for (int i : f) {
            System.out.print(i + " ");
        }
    }
}
