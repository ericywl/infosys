package eric.quiz3_2015.Q3;


public class CountVowel {
    public static int recurCountVowel(String s) {
        if (s == null) return 0;
        if (s.length() == 0) return 0;

        int temp = 0;
        String vowels = "aeiouAEIOU";

        if (vowels.contains(s.substring(0, 1)))
            temp = 1;

        return temp + recurCountVowel(s.substring(1, s.length()));
    }
}
