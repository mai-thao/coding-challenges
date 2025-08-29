/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Time complexity: O(n*m) because iterating through each digit in num AND iterating again to reduce down to 1 digit
 * Space complexity: O(1) because no extra dataset or memory created
 */
public class AddDigits {
    public static int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int popped = num % 10;
            sum += popped;
            num = num / 10;
            if (num == 0 && sum >= 10) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38)); // 3+8=11 -> 1+1=2 -> 2
        System.out.println(addDigits(0)); // 0
    }
}
