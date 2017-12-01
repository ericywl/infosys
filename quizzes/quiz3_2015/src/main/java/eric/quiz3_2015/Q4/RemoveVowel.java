package eric.quiz3_2015.Q4;


public class RemoveVowel {
    public static String recurRemoveVowel(String s) {
        if (s == null) return "";
        if (s.length() == 0) return "";

        String vowels = "aeiouAEIOU";
        String recur = recurRemoveVowel(s.substring(1, s.length()));

        if (!vowels.contains(s.substring(0, 1)))
            return s.substring(0, 1) + recur;

        return recur;
    }
}
