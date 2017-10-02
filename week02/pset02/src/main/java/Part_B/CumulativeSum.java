package Part_B;
// Cohort Question 5
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.Arrays;

public class CumulativeSum {
   public static void main (String[] args) {
       int d[] = {2,3,1,5,6,2,7};
       
       cumulativeSum(d, 1);
       System.out.println(Arrays.toString(d));
   }

    public static void cumulativeSum(int data[], int n) {
        data[n] += data[n - 1];

        if (n < data.length - 1) {
            cumulativeSum(data, n + 1);
        }
    }

}
