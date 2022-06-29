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

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = reverseKGroup(n1,2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getGroupEnd(head, k);
        if (end == null) {
            return head;
        }

        //最总head一定是第一组的end
        head = end;
        //第一组
        reverseGroup(start, end);
        //上一组的结尾
        ListNode lastEndNode = start;

        //下一组开始
        while (lastEndNode.next != null) {
            start = lastEndNode.next;
            end = getGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverseGroup(start, end);
            lastEndNode.next = end;
            lastEndNode = start;
        }

        return head;
    }

    public static ListNode getGroupEnd(ListNode start, int k) {
            /*while (--k != 0 && start != null) {
                start=start.next;
            }*/
        for (int i = 1; i < k; i++) {
            if (start == null) {
                return null;
            }
            start = start.next;
        }
        return start;
    }

    public static void reverseGroup(ListNode start, ListNode end) {
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


    static class ListNode {
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
