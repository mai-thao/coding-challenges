public class FindMiddleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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

    public static void main(String[] main) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        printNodes(node5);
        printNodes(middleNode(node5)); // 3->4->5

        System.out.println();

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(5, node6);
        ListNode node8 = new ListNode(4, node7);
        ListNode node9 = new ListNode(3, node8);
        ListNode node10 = new ListNode(2, node9);
        ListNode node11 = new ListNode(1, node10);
        printNodes(node11);
        printNodes(middleNode(node11)); // 4->5->6

        System.out.println();

        ListNode node12 = new ListNode(1);
        printNodes(node12);
        printNodes(middleNode(node12)); // 1

        System.out.println();

        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(8, node13);
        printNodes(node14);
        printNodes(middleNode(node14)); // 9
    }
}
