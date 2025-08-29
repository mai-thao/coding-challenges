/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Time complexity: O(n) because iterating through each digit in the num
 * Space complexity: O(n) because creating a new string to get the length of the integer
 */
public class AddDigits {
    public static int addDigits(int num) {
        int sum = 0;
        while (String.valueOf(num).length() > 1) {
            int popped = num % 10;
            sum += popped;
            num = num / 10;
            if (String.valueOf(num).length() == 1) {
                sum += num;
                num = sum;
                sum = 0;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38)); // 2
        System.out.println(addDigits(0)); // 0
    }
}
