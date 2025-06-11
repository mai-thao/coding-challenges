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

    public static void main(String[] args) {
    }
}
