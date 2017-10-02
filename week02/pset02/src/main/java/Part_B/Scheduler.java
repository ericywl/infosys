package Part_B;
// Homework Question 2
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.*;

public class Scheduler {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] appointments = new String[2];
        int appointmentsMade = 0;

        System.out.println("Welcome to the Appointment Scheduler.");
        System.out.println("You can schedule an appointment " +
                "at 1 or 2 pm.\n");

        do {
            try {
                System.out.print("Please enter your preferred timing: ");
                String timeStr = reader.nextLine();
                if (!(timeStr.equals("1") || timeStr.equals("2"))) {
                    throw new InvalidTimeException();
                }

                int time = Integer.valueOf(timeStr);

                // if appointments[x] is not written
                if (!(appointments[time - 1] == null)) {
                    throw new TimeInUseException();
                }

                System.out.print("Please enter your name: ");
                String name = reader.nextLine();
                appointments[time - 1] = name;
                appointmentsMade++;

            } catch (InvalidTimeException ex) {
                System.out.println("The timing is invalid");
            } catch (TimeInUseException ex) {
                System.out.println("The timing is occupied");
            }

        } while (appointmentsMade < 2);

        System.out.println("\n1 pm: " + appointments[0]);
        System.out.println("2 pm: " + appointments[1]);
    }

    public static class InvalidTimeException extends Exception {

    }

    public static class TimeInUseException extends Exception {

    }
}



