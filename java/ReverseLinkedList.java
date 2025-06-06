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
    }
}
