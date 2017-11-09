package eric.quiz2_2017;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        tryEnumFor();
        tryEnumWhile();
    }

    private static Vector<String> vector = new Vector<>();
    private static List<String> list = new ArrayList<>();
    static {
        vector.add("A");
        vector.add("C");
        vector.add("D");
        vector.add("B");
        vector.add("G");
        vector.add("E");

        list.add("A");
        list.add("C");
        list.add("D");
        list.add("B");
        list.add("G");
        list.add("E");
    }

    private static void tryIterWhile() {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (!s.equals("D"))
                System.out.println(s);
        }
    }

    private static void tryIterFor() {
        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String s = iter.next();
            if (!s.equals("D"))
                System.out.println(s);
        }
    }

    private static void tryEnumWhile() {
        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            String s = en.nextElement();
            if (!s.equals("D"))
                System.out.println(s);
        }
    }

    private static void tryEnumFor() {
        for (Enumeration<String> en = vector.elements(); en.hasMoreElements();) {
            String s = en.nextElement();
            if (!s.equals("D"))
                System.out.println(s);
        }
    }

}
