import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string
 * is given as an array of characters `s`.
 *
 * Time complexity: O(n/2) -> O(n) because iterating half of the char array
 * Space complexity: O(1) because not using extra dataset or memory
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] test1 = new char[]{'h','e','l','l','o'};
        System.out.println("Before: " + Arrays.toString(test1));
        reverseString(test1);
        System.out.println("After: " + Arrays.toString(test1));

        char[] test2 = new char[]{'H','a','n','n','a', 'h'};
        System.out.println("Before: " + Arrays.toString(test2));
        reverseString(test2);
        System.out.println("After: " + Arrays.toString(test2));

        char[] test3 = new char[]{'b'};
        System.out.println("Before: " + Arrays.toString(test3));
        reverseString(test3);
        System.out.println("After: " + Arrays.toString(test3));
    }
}
