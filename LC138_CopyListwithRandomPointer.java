import java.util.HashMap;

public class LC138_CopyListwithRandomPointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null){
                return null;
            }

            HashMap<Node, Node> map = new HashMap<>();

            Node newHead = new Node(head.val), curr = head.next;
            Node tail = newHead;
            newHead.random = head.random;
            map.put(head, newHead);

            while (curr != null){
                tail.next = new Node(curr.val);
                map.put(curr, tail.next);

                tail.next.random = curr.random;
                curr = curr.next;
                tail = tail.next;
            }

            curr = newHead;
            while (curr != null){
                curr.random = map.get(curr.random);
                curr = curr.next;
            }

            return newHead;
        }
    }

}
