//public class LC21_MergeTwoSortedLists {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public LC_206ReverseLinkedList.ListNode mergeTwoLists(LC_206ReverseLinkedList.ListNode list1, ListNode list2) {
//            LC_206ReverseLinkedList.ListNode dummy = new LC_206ReverseLinkedList.ListNode(-1), tail = dummy;
//
//            while (list1 != null && list2 != null){
////                if (list1.val <= list2.val){
////                    tail.next = list1;
////                    list1 = list1.next;
////                } else {
////                    tail.next = list2;
////                    list2 = list2.next;
////                }
////
////                tail = tail.next;
////            }
////
////            tail.next = (list1 != null) ? list1 : list2;
////            return dummy.next;
////        }
//    }
//}
