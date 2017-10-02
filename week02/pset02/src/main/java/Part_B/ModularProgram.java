package Part_B;
// Homework Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.InputMismatchException;
import java.util.Scanner;

public class ModularProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;

        System.out.println("Welcome to the modulus computer");
        do {
            try {
                tryException(input);
            } catch (InputMismatchException ex) {
                System.out.println("Sorry you must enter two integer inputs");
            } catch (ArithmeticException ex) {
                System.out.println("Sorry, cannot compute mod by 0");
            } finally {
                System.out.println("Do another pair of values ? (y)");
                String str = input.nextLine();
                char ch = str.charAt(0);
                System.out.println(" ch = " + ch);

                if ((ch != 'y') && (ch != 'Y')) {
                    continueInput = false;
                }
            }
        } while (continueInput);
    }

    public static void tryException(Scanner input) throws InputMismatchException {
        System.out.println("Enter two integer values");
        System.out.print("First value: ");
        String num1Str = input.nextLine();
        System.out.print("Second value: ");
        String num2Str = input.nextLine();

        if (!(isInteger(num1Str) && isInteger(num2Str))) {
            throw new InputMismatchException();
        }

        int num1 = Integer.valueOf(num1Str);
        int num2 = Integer.valueOf(num2Str);
        System.out.println("Result: " + (num1 % num2));
    }

    public static boolean isInteger(String text) {
        return text.matches("^-?\\d+$");
    }
}
