/**
 *  Given the heads of two sorted linked lists, merge them into one single sorted linked list. Return the head of the merged linked list.
 *
 *  Time complexity: O(n + m) since traversing each node from both list once to build the merged list
 *  Space complexity: O(1) because no extra datasets needed
 */
public class MergeSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Builds a "new" tail list by "appending" the lower node from either list1 or list2
    // Not truly appending (hence the quotations), just relinking nodes
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedHead = new ListNode(-1);
        ListNode tail = mergedHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return mergedHead.next;
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
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);
        printNodes(node3); // 1->2->4
        printNodes(node6); // 1->3->4
        ListNode mergedNodes = mergeTwoLists(node3, node6);
        printNodes(mergedNodes); // 1->1->2->3->4->4
        System.out.println();

        // Test 2
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(2, node8);
        ListNode node10 = new ListNode(1, node9);
        printNodes(node7); // 5
        printNodes(node10); // 1->2->4
        mergedNodes = mergeTwoLists(node7, node10);
        printNodes(mergedNodes); // 1->2->4->5
        System.out.println();

        // Test 3
        ListNode node12 = new ListNode(1);
        printNodes(node12); // 1
        mergedNodes = mergeTwoLists(null, node12);
        printNodes(mergedNodes); // 1
    }
}
