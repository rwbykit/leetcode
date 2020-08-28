package leetcode;

public class _0083RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = ListNode.create("1->1->2->3->3", "->");
        ListNode r = deleteDuplicates(head);
        System.out.println(ListNode.read(r));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }

        }
        return head;
    }

}
