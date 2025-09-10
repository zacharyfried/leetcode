public class LC141_LinkedListCycle {
    public boolean hasCycle(LC_206ReverseLinkedList.ListNode head) {
        if (head == null) return false;
        LC_206ReverseLinkedList.ListNode slow = head;
        LC_206ReverseLinkedList.ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;

    }
}
