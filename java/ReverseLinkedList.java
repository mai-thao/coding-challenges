/**
 *  Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *  Time complexity: O(n) because traversing the entire node list
 *  Space complexity: O(1) because no extra datasets needed
 */
public class ReverseLinkedList {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    // Helper fxn to print the values of each node in order
    public static void printNodes(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test 1
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        printNodes(node5);
        ListNode reversedNodes = reverseList(node5);
        printNodes(reversedNodes);

        // Test 2
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1, node6);
        printNodes(node7);
        reversedNodes = reverseList(node7);
        printNodes(reversedNodes);
    }
}
