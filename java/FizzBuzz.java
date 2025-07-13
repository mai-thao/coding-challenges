import java.util.ArrayList;
import java.util.List;

/**
 * The classic Fizz Buzz problem! Implement it using the following constraints.
 *
 * Given an integer `n`, return a string array answer (1-indexed) where:
 *     answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 *     answer[i] == "Fizz" if i is divisible by 3.
 *     answer[i] == "Buzz" if i is divisible by 5.
 *     answer[i] == i (as a string) if none of the above conditions are true.
 *
 * Time complexity: O(n) because traversing numbers from 1 to n
 * Space complexity: O(n) because creating a new ArrayList for the output
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) { // `n % x == 0` means that `n` can be divided by `x`
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(3)); // [1,2,Fizz]
        System.out.println(fizzBuzz(5)); // [1,2,Fizz,4,Buzz]
        System.out.println(fizzBuzz(15)); // [1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz]
        System.out.println(fizzBuzz(1)); // [1]
    }
}
