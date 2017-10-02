package Part_A;// Question 2
// total: 10 points

//===============================================
// todo: provide the value for “str” 
//===============================================


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String str = "a{0,3}b{0,3}c{0,3}";

        Pattern p1 = Pattern.compile(str);
        Matcher m = p1.matcher("aaabcc");
        boolean b = m.matches();
        System.out.println(b);

        Matcher m2 = p1.matcher("accc");
        boolean b2 = m2.matches();
        System.out.println(b2);

        Matcher m3 = p1.matcher("aaaabccccc");
        boolean b3 = m3.matches();
        System.out.println(b3);

        Matcher m4 = p1.matcher("aabbccccc");
        boolean b4 = m4.matches();
        System.out.println(b4);

        Matcher m5 = p1.matcher("aab");
        boolean b5 = m5.matches();
        System.out.println(b5);

    }
}
