package Part_B;
// Homework Question 6
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class ReverseLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        System.out.println ("Calling reverse: ");
        String output = reverse(s);
        System.out.println("output = " + output);
    }

    public static String reverse(String s){
        if (s.length() <= 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }
}
