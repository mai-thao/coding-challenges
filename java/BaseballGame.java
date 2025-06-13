import java.util.Stack;

/**
 * Given a string of operations, return the sum of all the records after applying each operation.
 *
 * An operation can be:
 * - integer "x" -> records a new score of x
 * - "+" -> records a new score that is the sum of the previous two scores
 * - "D" -> records a new score that is the double of the previous score
 * - "C" -> invalidates the previous score, removing it from the record
 *
 * Each element will only be 1 of these 4 operation.
 * For operation "+", there will always be at least two previous scores on the record.
 * For operations "C" and "D", there will always be at least one previous score on the record.
 *
 * Time complexity:
 * Space complexity:
 */
public class BaseballGame {
    public static int calculatePoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String operation: operations) {
            if (operation.equals("+")) {
                int popped = scores.pop();
                int peeked = scores.peek();
                int sum = popped + peeked;
                scores.push(popped);
                scores.push(sum);
            } else if (operation.equals("D")){
                int peeked = scores.peek();
                int doubled = peeked * 2;
                scores.push(doubled);
            } else if (operation.equals("C")) {
                scores.pop();
            } else {
                scores.push(Integer.parseInt(operation));
            }
        }
        int total = 0;
        while (!scores.isEmpty()) {
            total += scores.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calculatePoints(new String[]{"5","2","C","D","+"})); // 30
        System.out.println(calculatePoints(new String[]{"5","-2","4","C","D","9","+","+"})); // 27
        System.out.println(calculatePoints(new String[]{"1","C"})); // 0
        System.out.println(calculatePoints(new String[]{"5","D"})); // 15
        System.out.println(calculatePoints(new String[]{"1"})); // 1
    }
}
