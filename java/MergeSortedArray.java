/**
 * Given two integer arrays sorted in non-decreasing order (nums1 and nums2) and two integers representing the number of elements in each array (m and n, respectively),
 * merge both arrays into a single sorted array in non-decreasing order. The length of nums1 is m + n so the final merged array should be inside nums1.
 *
 * Time complexity:
 * Space complexity:
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
    }

    public static void printArray(String text, int[] inputArr) {
        System.out.print(text);
        for (int intElem: inputArr) {
            System.out.print(intElem + ',');
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        printArray("Before: ", nums1);
        merge(nums1, m, nums2, n);
        printArray("After: ", nums1);
    }
}
