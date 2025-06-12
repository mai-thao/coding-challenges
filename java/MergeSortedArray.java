/**
 * Given two integer arrays sorted in non-decreasing order (nums1 and nums2) and two integers representing the number of elements in each array (m and n, respectively),
 * merge both arrays into a single sorted array in non-decreasing order. The length of nums1 is m + n so the final merged array should be inside nums1.
 *
 * Time complexity:
 * Space complexity:
 */
public class MergeSortedArray {
    // Used two-pointer technique
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int openSpace = m + n - 1;

        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] < nums2[n2]) {
                nums1[openSpace] = nums2[n2];
                n2--;
            } else {
                nums1[openSpace] = nums1[n1];
                n1--;
            }
            openSpace--;
        }
    }

    public static void printArray(String text, int[] inputArr) {
        System.out.print(text);
        for (int intElem: inputArr) {
            System.out.print(intElem + ",");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        printArray("Before: ", nums1);
        merge(nums1, m, nums2, n);
        System.out.println();
        printArray("After: ", nums1);
    }
}
