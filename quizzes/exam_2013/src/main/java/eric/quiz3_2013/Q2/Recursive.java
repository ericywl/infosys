package eric.quiz3_2013.Q2;


public class Recursive {
    public static int countPairs(String str) {
        if (str == null) return 0;
        if (str.length() < 3) return 0;

        int out = 0;
        if (str.charAt(0) == str.charAt(2)) out = 1;

        return out + countPairs(str.substring(1, str.length()));
    }

    public static int count11(String str) {
        if (str == null) return 0;
        if (str.length() < 2) return 0;

        if (str.charAt(0) == '1' && str.charAt(1) == '1')
            return 1 + count11(str.substring(2, str.length()));

        return count11(str.substring(1, str.length()));
    }

    public static void main(String[] args) {
        System.out.println(count11("abc11x11x11"));
        System.out.println(count11("11abc11"));
        System.out.println(count11("111"));
    }
}
