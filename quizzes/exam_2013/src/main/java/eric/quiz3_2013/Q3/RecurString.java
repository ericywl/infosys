package eric.quiz3_2013.Q3;


public class RecurString {
    public static String recurStringReverse(String input) {
        if (input == null) return null;

        input = input.trim();
        if (input.length() == 0) return "";
        if (!input.contains(" ")) return input;

        int spaceIndex = input.indexOf(" ");
        String pop = input.substring(0, spaceIndex);

        return recurStringReverse(input.substring(spaceIndex + 1, input.length())) + " " + pop;
    }

    public static void main(String[] args) {
        System.out.println(recurStringReverse("man ate fish"));
    }
}
