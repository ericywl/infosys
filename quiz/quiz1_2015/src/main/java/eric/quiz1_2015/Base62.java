package eric.quiz1_2015;

import java.util.Arrays;

public class Base62 {
    public static boolean divisible1(String x) {
        Character[] base62Digits = new Character[62];
        double result = 0;
        int xLength = x.length();

        for (int i = 0; i < 10; i++) {
            base62Digits[i] = (char) (i + '0');
        }

        for (int i = 0; i < 26; i++) {
            base62Digits[i + 10] = (char) (i + 'A');
            base62Digits[i + 36] = (char) (i + 'a');
        }

        for (int j = 0; j < xLength; j++) {
            char xChar = x.charAt(xLength - j - 1);
            int number = Arrays.asList(base62Digits).indexOf(xChar);

            result += (number * Math.pow(62, j));
            result %= 61;
        }

        return result == 0;
    }

    public static boolean divisible2(String x) {
        int xLength = x.length();
        int digit;
        double result = 0;

        for (int i = 0; i < xLength; i++) {
            char xChar = x.toCharArray()[i];

            if (xChar >= 'a') {
                digit = xChar - 'a' + 36;
            } else if (xChar >= 'A') {
                digit = xChar - 'A' + 10;
            } else {
                digit = xChar - '0';
            }

            result += (digit * Math.pow(62, i));
            result %= 61;
        }

        return result == 0;
    }

    public static void main(String[] args) {
        System.out.println(divisible1("zzzzzzzzz"));
        System.out.println(divisible2("zzzzzzzzz"));
        System.out.println("");
        System.out.println(divisible1("2P6"));
        System.out.println(divisible2("2P6"));
    }
}
