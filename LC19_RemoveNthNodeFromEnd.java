public class LC19_RemoveNthNodeFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null){
                return head;
            }

            int size = 0;
            ListNode curr = head;

            while (curr != null){
                size++;
                curr = curr.next;
            }

            if (size == n){
                head = head.next;
                return head;
            }





            curr = head;
            ListNode prev = null;

            int steps = size - n;

            int i = 0;
            while (i < steps && curr != null){
                prev = curr;
                curr = curr.next;
                i++;
            }

            if (curr.next == null){
                prev.next = null;
            } else {
                prev.next = curr.next;
            }

            return head;



        }

    }

}
