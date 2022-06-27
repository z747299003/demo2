package org.example.algorithm.list;

import javax.swing.*;

public class singleList {
    public static void main(String[] args) {
       /* Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        n1.next = n2;
        n2.next = n3;
        n1 = reverseSingleLink(n1);
        System.out.println(n1.value + " " + n1.next.value + " " + n1.next.next.value);*/

        DubbleNode n1 = new DubbleNode("1");
        DubbleNode n2 = new DubbleNode("2");
        DubbleNode n3 = new DubbleNode("3");
        n1.next = n2;
        n1.pre=null;
        n2.next = n3;
        n2.pre=n1;
        n3.next=null;
        n3.pre=n2;
        n1 = reverseDubbleLink(n1);
        System.out.println(n1.value + " " + n1.next.value + " " + n1.next.next.value);
        System.out.println(n3.value + " " + n3.next.value + " " + n3.next.next.value);
    }

    public static Node reverseSingleLink(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DubbleNode reverseDubbleLink(DubbleNode head) {
        DubbleNode pre = null;
        DubbleNode next = null;
        while (head != null) {
            next=head.next;
            head.next=pre;
            head.pre=next;
            pre=head;
            head=next;
        }
        return pre;
    }

}

class Node {
    String value;
    Node next;

    Node(String value) {
        this.value = value;
    }
}

class DubbleNode {
    String value;
    DubbleNode pre;
    DubbleNode next;

    DubbleNode(String value) {
        this.value = value;
    }
}
