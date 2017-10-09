package Part_A;
// Question 3
// total: 30 points

//===============================================
// todo: complete the following program
//===============================================


public class TestMatrix {
    public static void main(String[] args) {
        double[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] b = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] c = matMpy(a, b);

        printMat(c);

        //////

        int[] f = new int[5];
        f[0] = 2;
        f[1] = 5;
        int[] g = {1, 3, 7};

        mergeSortedArray(f, 2, g, 3);

        printMat(f);


    }

    public static void printMat(int[] c) {
        int m;
        m = c.length;
        for (int i = 0; i < m; i++) {
            System.out.print(c[i] + ",  ");
        }
        System.out.println();
    }

    public static void printMat(double[][] c) {
        int m, n;
        m = c.length;
        n = c[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + ",  ");
            }
            System.out.println();
        }

    }


    public static double[][] matMpy(double[][] a, double[][] b) {
        int a_row = a.length;
        int a_column = a[0].length;
        int b_row = b.length;
        int b_column = b[0].length;

        if (a_column != b_row) {
            return null;
        }

        double[][] c = new double[a_row][b_column];

        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < b_column; j++) {
                for (int x = 0; x < a_column; x++) {
                    c[i][j] += a[i][x] * b[x][j];
                }
            }
        }

        return c;
    }

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

}
