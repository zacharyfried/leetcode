import java.util.ArrayList;

public class LC_206ReverseLinkedList {
    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ArrayList<ListNode> list = new ArrayList<>();

            ListNode curr = head;

            while (curr != null) {
                list.add(curr);
                curr = curr.next;
            }

            ListNode res = list.get(list.size() - 1);
            if (list.size() == 1) return res;
            curr = res;
            for (int i = list.size() - 2; i >= 0; i--) {
                curr.next = list.get(i);
                curr = list.get(i);
            }
            list.get(0).next = null;

            return res;
        }
    }
}
