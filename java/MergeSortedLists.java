/**
 *  Given the heads of two sorted linked lists, merge them into one single sorted linked list. Return the head of the merged linked list.
 *
 *  Time complexity:
 *  Space complexity:
 */
public class MergeSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode mergedHead = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergedHead == null) {
                    mergedHead = list1;
                }
                ListNode temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else {
                if (mergedHead == null) {
                    mergedHead = list2;
                }
                ListNode temp = list2.next;
                list2.next = list1;
                list2 = temp;
            }
        }
        return mergedHead;
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

        // Test 2
        // TODO: Causes infinite loop, fix this!
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(2, node8);
        ListNode node10 = new ListNode(1, node9);
        printNodes(node3); // 5
        printNodes(node6); // 1->2->4
        mergedNodes = mergeTwoLists(node3, node6);
        printNodes(mergedNodes); // 1->2->4->5

        // Test 3
        ListNode node11 = null;
        ListNode node12 = new ListNode(1);
        printNodes(node12); // 1
        mergedNodes = mergeTwoLists(node11, node12);
        printNodes(mergedNodes); // 1
    }
}
