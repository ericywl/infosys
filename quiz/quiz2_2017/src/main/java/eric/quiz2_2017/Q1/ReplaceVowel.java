package eric.quiz2_2017.Q1;

public class ReplaceVowel {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("calling replace with google -> " + replaceVowel("google"));
        System.out.println("calling replace with f -> " + replaceVowel("f"));
        System.out.println("calling replace with befuddle -> " + replaceVowel("befuddle"));
        System.out.println("calling replace with try -> " + replaceVowel("try"));
        System.out.println("calling replace with abracadabra -> " + replaceVowel("abracadabra"));
    }

    public static String replaceVowel(String s) {
        if (s == null) return "";
        if (s.length() == 0) return "";

        String vowels = "aeiouAEIOU";
        if (vowels.contains(s.substring(0, 1)))
            return "oo" + replaceVowel(s.substring(1, s.length()));

        return s.charAt(0) + replaceVowel(s.substring(1, s.length()));

    }


}
