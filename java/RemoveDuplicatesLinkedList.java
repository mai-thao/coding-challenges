/**
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 *
 * Note: The list is guaranteed to be sorted in ascending order.
 *
 * Time complexity: O(n) because we are traversing each node in the linked list
 * Space complexity: O(1) because no extra dataset needed, just relinking of nodes
 */
public class RemoveDuplicatesLinkedList {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }

    // Helper fxn to print the values of each node in order
    public static void printNodes(ListNode head) {
        if (head == null) System.out.print("Empty");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printNodes(deleteDuplicates(null)); // [] -> []

        printNodes(deleteDuplicates(new ListNode(1))); // [1] -> [1]

        ListNode t1Node2 = new ListNode(2);
        ListNode t1DuplicateNode1 = new ListNode(1, t1Node2);
        ListNode t1Root = new ListNode(1, t1DuplicateNode1);
        printNodes(deleteDuplicates(t1Root)); // [1,1,2] -> [1,2]

        ListNode t2DuplicateNode3 = new ListNode(3);
        ListNode t2Node3 = new ListNode(3, t2DuplicateNode3);
        ListNode t2node2 = new ListNode(2, t2Node3);
        ListNode t2DuplicateNode1 = new ListNode(1, t2node2);
        ListNode t2Root = new ListNode(1, t2DuplicateNode1);
        printNodes(deleteDuplicates(t2Root));// [1,1,2,3,3] -> [1,2,3]
    }
}
