package Part_B_HW.piwords;

public class BaseTranslator {
    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     * <p>
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     * <p>
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     * <p>
     * for (i < precisionB) {
     * 1. Keep a carry, initialize to 0.
     * 2. From RIGHT to LEFT
     * a. x = multiply the jth digit by baseB and add the carry
     * b. the new jth digit is x % baseA
     * c. carry = x / baseA
     * 3. output[i] = carry
     * }
     * If digits[j] < 0 or digits[j] >= baseA for any j, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     *
     * @param digits     The input array to translate. This array is not mutated.
     * @param baseA      The base that the input array is expressed in.
     * @param baseB      The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     */
    public static int[] convertBase(int[] digits, int baseA, int baseB, int precisionB) {
        int digitsLength = digits.length;
        int[] output = new int[precisionB];
        int[] digitsCopy = digits.clone();

        if (baseA < 2 || baseB < 2 || precisionB < 1 || digits == new int[0]) {
            return null;
        }

        for (int digit : digitsCopy) {
            if (digit < 0 || digit >= baseA) {
                return null;
            }
        }

        for (int i = 0; i < precisionB; i++) {
            int carry = 0;

            for (int j = digitsLength - 1; j > -1; j--) {
                int x = digitsCopy[j] * baseB + carry;
                digitsCopy[j] = x % baseA;
                carry = x / baseA;
            }

            output[i] = carry;
        }

        return output;
    }
}
