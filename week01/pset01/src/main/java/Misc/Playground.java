package Misc;

import java.util.HashMap;
import java.util.Map;

public class Playground {
    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("z", 1);
        a.put("b", 3);

        System.out.println(a);
    }
}
