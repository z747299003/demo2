package org.example.algorithm.list;

import java.util.Objects;

public class ListToStack {

    private Node head = null;
    private int size = 0;

    /**
     * 入栈
     *
     * @param node
     * @return
     */
    public Node offer(Node node) {
        if (Objects.isNull(head)) {
            head = node;
            head.next = null;
            size++;
        } else {
            Node next = head;
            while (next.next != null) {
                next = next.next;
            }
            next.next = node;
            size++;
        }
        printStack(this);
        return node;
    }

    /**
     * 查看元素
     *
     * @return
     */
    public Node peek() {
        if (head == null) {
            return null;
        } else {
            Node next = head;
            while (next.next != null) {
                next = next.next;
            }
            return next;
        }
    }

    /**
     * 弹出元素
     *
     * @return
     */
    public Node poll() {
        if (head == null) {
            return null;
        } else {
            Node next = head;
            Node last = head;
            while (next.next != null) {
                if (next.next.next == null) {
                    last=next.next;
                    next.next = null;
                    size--;
                    break;
                }
                next = next.next;
            }
            return last;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");

        ListToStack stack = new ListToStack();
        stack.offer(n1);
        stack.offer(n2);
        stack.offer(n3);
        System.out.println(stack.peek().value);
        printStack(stack);

        System.out.println("取出 " + stack.poll().value);
        System.out.println("大小 " + stack.size());
        printStack(stack);
        //System.out.println(n1.value + " " + n1.next.value + " " + n1.next.next.value);
    }

    public int size() {
        return this.size;
    }

    public static void printStack(ListToStack stack) {
        Node next = stack.head;
        while (next != null) {
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println(" ");

    }
}

