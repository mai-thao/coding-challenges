/**
 *  Given the head of a linked list, determine if it has a cycle in it.
 *
 *  Time complexity: O(n) because traversing the entire linked list
 *  Space complexity: O(1) because no extra datasets needed
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Uses slow and fast pointer pattern (aka Hare and Tortoise algorithm)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle node
        System.out.println(hasCycle(node1)); // true

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);
        node5.next = node6;
        node6.next = node7;
        System.out.println(hasCycle(node5)); // false

        ListNode node8 = new ListNode(1);
        System.out.println(hasCycle(node8)); // false
    }
}
