import java.util.*;

public class LC143_ReorderList {

    // Inner class definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head != null && head.next != null && head.next.next == null) return;

            ArrayList<ListNode> list = new ArrayList<>();
            ListNode curr = head;
            ListNode prev = null;

            // Collect nodes into list
            while (curr != null) {
                list.add(curr);
                prev = curr;
                curr = curr.next;
                prev.next = null;
            }

            // Reorder
            int i = 0;
            for (i = 0; i < (list.size() - 1) / 2; i++) {
                ListNode farNode = list.get(list.size() - 1 - i);
                list.get(i).next = farNode;
                farNode.next = list.get(i + 1);
            }

            i--;
            if (list.size() % 2 == 0) {
                list.get(i + 1).next = list.get(i + 2);
            }
        }
    }
}
