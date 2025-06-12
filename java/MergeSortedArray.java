/**
 * Given two integer arrays sorted in non-decreasing order (nums1 and nums2) and two integers representing the number of elements in each array (m and n, respectively),
 * merge both arrays into a single sorted array in non-decreasing order. The length of nums1 is m + n so the final merged array should be inside nums1.
 *
 * Time complexity: O(m + n) because traversing both arrays
 * Space complexity: O(1) because modifying nums1 in place with no extra dataset created
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
        // Handles leftover elements from second array
        while (n2 >= 0) {
            nums1[openSpace] = nums2[n2];
            n2--;
        }
    }

    public static void printArray(String text, int[] inputArr) {
        System.out.print(text);
        for (int intElem: inputArr) {
            System.out.print(intElem + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;
        printArray("Before: ", nums1);
        merge(nums1, m, nums2, n);
        System.out.println();
        printArray("After: ", nums1); // Should be: 1,2,2,3,5,6
        System.out.println();

        // Edge case where first array is empty
        // The 0 is ignored, just meant to allocate space for the second array
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        printArray("Before: ", nums1);
        merge(nums1, m, nums2, n);
        System.out.println();
        printArray("After: ", nums1); // Should be: 1
        System.out.println();

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        printArray("Before: ", nums1);
        merge(nums1, m, nums2, n);
        System.out.println();
        printArray("After: ", nums1); // Should be: 1
    }
}
