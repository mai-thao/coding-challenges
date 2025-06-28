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
        printNodes(node5); // 1->2->3->4->5
        ListNode reversedNodes = reverseList(node5);
        printNodes(reversedNodes); // 5->4->3->2->1

        // Test 2
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1, node6);
        printNodes(node7); // 1->2
        reversedNodes = reverseList(node7);
        printNodes(reversedNodes); // 2->1

        // Test 3
        ListNode node8 = new ListNode(11);
        printNodes(node8); // 11
        reversedNodes = reverseList(node8);
        printNodes(reversedNodes); // 11

        // Test 4
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(3, node9);
        ListNode node11 = new ListNode(5, node10);
        ListNode node12 = new ListNode(12, node11);
        ListNode node13 = new ListNode(1, node12);
        printNodes(node13); // 1->12->5->3->8
        reversedNodes = reverseList(node13);
        printNodes(reversedNodes); // 8->3->5->12->1
    }
}
