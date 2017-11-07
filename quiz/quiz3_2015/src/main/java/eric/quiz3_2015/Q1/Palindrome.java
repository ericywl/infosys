package eric.quiz3_2015.Q1;


public class Palindrome {
    public static boolean recurPalindrome (String strSubmitted) {
        if (strSubmitted == null) return false;

        int len = strSubmitted.length();
        if (len <= 1) return true;

        if (strSubmitted.charAt(0) != strSubmitted.charAt(len - 1))
            return false;

        return recurPalindrome(strSubmitted.substring(1, len - 1));
    }
}
