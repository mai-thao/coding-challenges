import java.util.Stack;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * A palindrome is a sequence that reads the same forward and backward.
 *
 * Examples-
 *
 * INPUT: [1,2,2,1]
 * OUTPUT: true
 *
 * INPUT: [1,2]
 * OUTPUT: false
 *
 * Time complexity: O(n) because traversing all the nodes in the linked list
 * Space complexity: O(n) because the Stack storing each node values
 */
public class LinkedListPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> visitedVals = new Stack<>();
        while (temp != null) {
            visitedVals.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (head.val != visitedVals.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1a = new ListNode(1);
        ListNode node2a = new ListNode(2);
        ListNode node3a = new ListNode(2);
        ListNode node4a = new ListNode(1);
        node1a.next = node2a;
        node2a.next = node3a;
        node3a.next = node4a;
        System.out.println(isPalindrome(node1a)); // true

        ListNode node1b = new ListNode(1);
        ListNode node2b = new ListNode(2);
        ListNode node3b = new ListNode(3);
        ListNode node4b = new ListNode(2);
        ListNode node5b = new ListNode(1);
        node1b.next = node2b;
        node2b.next = node3b;
        node3b.next = node4b;
        node4b.next = node5b;
        System.out.println(isPalindrome(node1b)); // true

        ListNode node1c = new ListNode(1);
        ListNode node2c = new ListNode(2);
        node1c.next = node2c;
        System.out.println(isPalindrome(node1c)); // false
    }
}
