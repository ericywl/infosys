package eric.quiz2_2015.Q3;


import java.util.List;

public class NoWhere extends Exception {
    static void test() {
        List<Integer> intList = null;
        int i = intList.get(2);
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (NullPointerException ex) {
            System.out.println("Error: ex");
            ex.printStackTrace();
        }
    }
}
