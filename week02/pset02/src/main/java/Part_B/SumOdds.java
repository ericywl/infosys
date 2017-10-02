package Part_B;
// Homework Question 5
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================


   public class SumOdds {
        public static void main (String[] args) {
            int number = 10134;
            System.out.println(sumOdd(number));

            }
        
        public static int sumOdd(int number) {
            if (number == 0) {
                return 0;
            }

            if (number % 2 == 0) {
                return sumOdd(number / 10);
            }

            return number % 10 + sumOdd(number / 10);
        }
    }
