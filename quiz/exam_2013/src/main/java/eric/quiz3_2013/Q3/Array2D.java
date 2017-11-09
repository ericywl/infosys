package eric.quiz3_2013.Q3;

public class Array2D {
    public static int[][] setZero(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr = setRowZero(arr, i);
                    arr = setColZero(arr, j);
                }
            }
        }

        return arr;
    }

    private static int[][] setRowZero(int[][] arr, int row) {
        int[] temp = new int[arr[row].length];

        arr[row] = temp;
        return arr;
    }

    private static int[][] setColZero(int[][] arr, int col) {
        for (int[] row : arr) {
            row[col] = 0;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {5, 5 ,5},
                {6, 9 ,0}
        };

        int[][] temp = setZero(arr);
        for (int[] row : temp) {
            for (int x : row)
                System.out.print(x + " ");

            System.out.print("\n");
        }
    }
}
