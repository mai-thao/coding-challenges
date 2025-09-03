import java.util.Arrays;

/**
 * Given an array, return a new array of trhe same length by applying the following transformation:
 * - For each i from 0 to a.length - 1 inclusive, b[i] = a[i-1] + a[i] + a[i+1]
 * - If an element in the sum a[i-1] + a[i] + a[i+1] does not exist, use 0 in its place
 * - For instance, b[0] = 0 + a[0] + a[1]
 *
 * Time complexity: O(n) because traversing each element in the array at least once
 * Space complexity: O(n) because created a new int array the same size as input array
 */
public class BasicArrayTransformation {
    public static int[] applyTransformation(int[] a) {
        int aLength = a.length;
        int[] b = new int[aLength];
        for (int i = 0; i < aLength; i++) {
            b[i] = a[i];
            if (i > 0) {
                b[i] += a[i-1];
            }
            if (i < aLength - 1) {
                b[i] += a[i+1];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyTransformation(new int[]{4,0,1,-2,3})));    // [4,5,-1,2,1]
        System.out.println(Arrays.toString(applyTransformation(new int[]{5})));             // [5]
        System.out.println(Arrays.toString(applyTransformation(new int[1])));               // [0]
        System.out.println(Arrays.toString(applyTransformation(new int[]{9,9,9,9})));       // [18,27,27,18]
        System.out.println(Arrays.toString(applyTransformation(new int[]{-9,-9,-9,-9})));   // [-18,-27,-27,-18]
    }
}
