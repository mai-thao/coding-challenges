import java.math.BigInteger;
import java.util.Arrays;

/**
 * Given a large integer represented as an integer array `digits`, increment the
 * last integer by one and then return the resulting array of digits.
 *
 * Note: `digits` does not contain leading 0's
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit: digits) {
            sb.append(digit);
        }
        String stringDigits = sb.toString();

        BigInteger convertedDigits = new BigInteger(stringDigits);
        convertedDigits = convertedDigits.add(BigInteger.ONE);
        stringDigits = convertedDigits.toString();

        int digitLen = stringDigits.length();
        int[] resultDigits = new int[digitLen];
        for (int i = 0; i < digitLen; i++) {
            resultDigits[i] = Character.getNumericValue(stringDigits.charAt(i));
        }

        return resultDigits;
    }

    public static int[] plusOneArithmetic(int[] digits) {
        int lastIdx = digits.length - 1;
        if (digits[lastIdx] < 9) {
            digits[lastIdx] = digits[lastIdx] + 1;
        } else {
            while (lastIdx >= 0 && digits[lastIdx] == 9) {
                digits[lastIdx] = 0;
                lastIdx--;
            }
            if (lastIdx >= 0) {
                digits[lastIdx] = digits[lastIdx] + 1;
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3}))); // [1,2,4]
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1}))); // [4,3,2,2]
        System.out.println(Arrays.toString(plusOne(new int[]{9}))); // [1,0]
        System.out.println(Arrays.toString(plusOne(new int[]{8,9,9}))); // [9,0,0]
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9,9,9}))); // [1,0,0,0,0,0,0]
        System.out.println(Arrays.toString(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}))); // [9,8,7,6,5,4,3,2,1,1]
        System.out.println(Arrays.toString(plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1}))); // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,2]

        System.out.println();

        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{1, 2, 3}))); // [1,2,4]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{4,3,2,1}))); // [4,3,2,2]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{9}))); // [1,0]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{8,9,9}))); // [9,0,0]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{9,9,9,9,9,9}))); // [1,0,0,0,0,0,0]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{9,8,7,6,5,4,3,2,1,0}))); // [9,8,7,6,5,4,3,2,1,1]
        System.out.println(Arrays.toString(plusOneArithmetic(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1}))); // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,2]
    }
}
