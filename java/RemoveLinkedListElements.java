/**
 * Given the `head` of a linked list and an integer `val`, remove all the nodes
 * of the linked list that has `Node.val == val`, and return the new head.
 *
 * Time complexity: O(n) because traversing every single node
 * Space complexity: O(1) because no extra dataset needed, just rearranging node pointers
 */
public class RemoveLinkedListElements {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode newHead = new ListNode(-1);
        ListNode prevHead = newHead;

        while (head != null) {
            if (head.val == val) {
                prevHead.next = head.next;
                head = head.next;
            } else {
                prevHead.next = head;
                prevHead = prevHead.next;
                head = head.next;
            }
        }
        return newHead.next;
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
        printNodes(removeElements(null, 1)); // [], val 1 -> []

        printNodes(removeElements(new ListNode(1), 1)); // [1], val 1 -> []

        printNodes(removeElements(new ListNode(2), 1)); // [2], val 1 -> [2]

        ListNode fourthNode7 = new ListNode(7);
        ListNode thirdNode7 = new ListNode(7, fourthNode7);
        ListNode secondNode7 = new ListNode(7, thirdNode7);
        ListNode firstNode7 = new ListNode(7, secondNode7);
        printNodes(removeElements(firstNode7, 7)); // [7,7,7,7], val = 7 -> []

        ListNode secondNode6 = new ListNode(6);
        ListNode node5 = new ListNode(5, secondNode6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode firstNode6 = new ListNode(6, node3);
        ListNode node2 = new ListNode(2, firstNode6);
        ListNode node1 = new ListNode(1, node2);
        printNodes(removeElements(node1, 6)); // [1,2,6,3,4,5,6], val = 7 -> [1,2,3,4,5]
    }
}
