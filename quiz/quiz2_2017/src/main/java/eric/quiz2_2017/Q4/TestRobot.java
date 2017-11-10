package eric.quiz2_2017.Q4;

import java.util.*;


class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}


public class TestRobot {
    public static void main(String[] args) {
        final int[][] grid = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };

        ArrayList<Point> path = new ArrayList<>();
        boolean success = getPath(3, 2, path, grid);
        System.out.println(success);

        if (success)
            System.out.println(path);
        // Note that the ArrayList<Point> path is empty before calling getPath.
        // Upon returning from getPath, path contains the coordinates
        // of the returned path if success is true (see output).
    }

    public static boolean getPath(int r, int c,
                                  ArrayList<Point> path, final int[][] grid) {
        
        return false;
    }
}


/*

Output:

true
[(0,0), (0,1), (1,1), (2,1), (2,2), (3,2)]
(note: your code may output any other valid path; it is not necessary to output all the valid paths)


Another test case:
final int [][] grid = {
    {0,0,0,0},
    {0,0,1,0},
    {0,1,0,1},
    {0,1,0,0}
};
In this case,

getPath(3,2,path, grid)
returns false.

*/

