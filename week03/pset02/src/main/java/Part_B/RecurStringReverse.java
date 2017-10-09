package Part_B;
// Homework Question 7
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class RecurStringReverse {
    public static void main(String[] args) {
        System.out.println(recurStringReverse("man ate fish"));
    }

    public static String recurStringReverse(String s) {
        int spaceIndex = s.indexOf(" ");
        if (spaceIndex < 0) {
            return s;
        }

        return recurStringReverse(s.substring(spaceIndex + 1)) + " " + s.substring(0, spaceIndex);
    }
}
