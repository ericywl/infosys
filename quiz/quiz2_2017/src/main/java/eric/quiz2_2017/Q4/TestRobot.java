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
        final int[][] grid1 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };

        final int[][] grid2 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0}
        };

        ArrayList<Point> path1 = new ArrayList<>();
        boolean success1 = getPath(3, 2, path1, grid1);
        System.out.println(success1);

        if (success1) {
            System.out.println(path1);
            System.out.println("");
        }

        ArrayList<Point> path2 = new ArrayList<>();
        boolean success2 = getPath(3, 2, path2, grid2);
        System.out.println(success2);

        if (success2) {
            System.out.println(path2);
        }
    }

    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {
        if (c < 0 || r < 0 || grid[r][c] == 1) return false;

        boolean AtOrigin = (r == 0) && (c == 0);
        boolean canGoToLeftOfTarget = getPath(r, c - 1, path, grid);
        Point point = new Point(r, c);

        if (AtOrigin || canGoToLeftOfTarget) {
            path.add(point);
            return true;
        }

        boolean canGoToTopOfTarget = getPath(r - 1, c, path, grid);
        if (canGoToTopOfTarget) {
            path.add(point);
            return true;
        }

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

