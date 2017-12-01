package eric.quiz3_2013.Q2;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) return -1;
        if (s1.length() < s2.length()) return 1;

        return 0;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("a", "ab", "abc");
        Collections.sort(strs, new StringLengthComparator());

        System.out.println(strs);
    }
}
