package eric.quiz3_2013.Q1;


public class Regex {
    public static boolean isMaster(String cardNum) {
        if (cardNum.length() != 16) return false;
        if (cardNum.matches("(.*)\\D(.*)")) return false;
        if (!cardNum.matches("5[1-5](.*)")) return false;

        return true;
    }

    public static boolean isVisa(String cardNum) {
        if (cardNum.length() != 16 && cardNum.length() != 13) return false;
        if (cardNum.matches("(.*)\\D(.*)")) return false;
        if (!cardNum.matches("4(.*)")) return false;

        return true;
    }

    public static boolean isJcb(String cardNum) {
        if (cardNum.matches("(.*)\\D(.*)")) return false;

        if (cardNum.length() == 15)
            if (cardNum.matches("2131(.*)") || cardNum.matches("1800(.*)"))
                return true;

        if (cardNum.length() == 16 && cardNum.matches("35(.*)")) return true;

        return false;
    }

    public static String removeWhiteSpaceAndLetter(String input) {
        return input.replaceAll("([a-zA-Z ])", "");
    }

    public static String cardType(String cardNum) {
        cardNum = cardNum.replaceAll("[ \\-]", "");

        if (isMaster(cardNum)) return "master";
        if (isVisa(cardNum)) return "visa";
        if (isJcb(cardNum)) return "jcb";

        return "other";
    }
}
