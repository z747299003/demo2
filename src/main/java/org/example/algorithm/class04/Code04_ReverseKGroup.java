package org.example.algorithm.class04;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Code04_ReverseKGroup {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode start = head;
            ListNode end = getGroupEnd(head, k);
            if(end==null){
                return head;
            }

            //第一组
            reverseGroup(start,end);
            //上一组的结尾
            ListNode lastEndNode=start;

            //下一组开始
            while(lastEndNode.next!=null){
                start=lastEndNode.next;
                end= getGroupEnd(start, k);
                if(end==null){
                    return head;
                }
                reverseGroup(start,end);
                lastEndNode=start;
                lastEndNode.next=end;
            }

            return head;
        }

        public ListNode getGroupEnd(ListNode start, int k) {
            /*while (--k != 0 && start != null) {
                start=start.next;
            }*/
            for (int i = 0; i < k; i++) {
                if (start == null) {
                    return null;
                }
                start = start.next;
            }
            return start;
        }

        public void reverseGroup(ListNode start, ListNode end) {
            ListNode cur = start;
            end = end.next;
            ListNode pre = null;
            ListNode next = null;
            while (cur != end) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next = end;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
