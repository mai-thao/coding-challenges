/**
 * Given an integer array, find the pair of adjacent elements
 * that has the largest product and return that product.
 *
 * Time complexity: O(n) because visiting each int in the array
 * Space complexity: O(1) because no extra dataset or memory used
 */
public class FindAdjacentElementsProduct {
    public static int findAdjElemsProduct(int[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException("Requires at least 2 elements!");
        int left = 0;
        int right = 1;
        int largestProduct = Integer.MIN_VALUE;
        while (right < arr.length) {
            int product = arr[left] * arr[right];
            if (product > largestProduct) {
                largestProduct = product;
            }
            left++;
            right++;
        }
        return largestProduct;
    }

    public static void main(String[] args) {
        try {
            findAdjElemsProduct(new int[]{1});
        } catch (Exception e) {
            System.out.println(e.getMessage());                             // Requires at least 2 elements!
        }
        System.out.println(findAdjElemsProduct(new int[]{0,0}));            // 0
        System.out.println(findAdjElemsProduct(new int[]{3,6,-2,-5,7,3}));  // 21
        System.out.println(findAdjElemsProduct(new int[]{3,4}));            // 12
        System.out.println(findAdjElemsProduct(new int[]{9,9,9,9}));        // 81
        System.out.println(findAdjElemsProduct(new int[]{-1,-2,-3}));       // 6
    }
}
