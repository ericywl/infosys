package Part_B;
// Cohort Question 6
// total: 5 points

//===============================================
// todo: complete the following program
//==============================================6


public class DoubleEachLetter {
    public static void main(String[] args) {
        String s = "HelloWorld";

        String output = doubleEachLetter(s);
        System.out.println("output = " + output);
    }

    public static String doubleEachLetter(String s) {
        if (s.length() <= 1) {
            return s + s;
        }

        String letter = String.valueOf(s.charAt(0));
        return letter + letter + doubleEachLetter(s.substring(1, s.length()));
    }
}
