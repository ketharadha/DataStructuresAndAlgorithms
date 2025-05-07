package com.collections;

public class SingleLinkedList {
    Node head;

    public class Node {
        Object data;
        Node next = null;
        public Node(Object data) {
            this.data = data;
        }
    }

    int index = 0;
    int count = 0;
    public void addLast(Object o) {
        Node n = new Node(o);
        if(head == null) {
            head = n;
            index++;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
            index++;
        }
        temp.next = n;
    }

    public void addFirst(Object o) {
        Node n = new Node(o);
        if(head == null) {
            head = n;
        } else {
            Node temp = head;
            n.next = temp;
            head = n;
        }
        index++;
    }

    public void addMiddle(Object o, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("Position should be greater than 0");
        }
        Node n = new Node(o);
        if(head == null) {
            head = n;
            return;
        } 
        Node temp = head;
        Node previous = null;
        for (int i = 0; i < position; i++) {
            previous = temp;
            temp = temp.next;
        }
        if(previous != null) {
            previous.next = n;
            n.next = temp;
            index++;
        }
    }

    public Object removeFirst() {
        if(head == null) {
            throw new RuntimeException("There no elements to remove");
        }
        Node temp = head;
        head = head.next;
        index--;
        return temp.data;
    }

    public Object removeLast() {
        if(head == null) {
            throw new RuntimeException("There are no elements to remove");
        }
        Node temp = head;
        Node previousNode = null;
        if(head.next == null) {
            head = null;
            return temp.data;
        }
        
        while(temp.next != null) {
            previousNode = temp;
            temp = temp.next;
        }
        if(previousNode != null) {
            previousNode.next = null;
            index--;
        }
        return temp.data;
    }

    public Object removeAt(int position) {
        if(position < 0 || position > index-1) {
            throw new IllegalArgumentException("Postion cannot be less than 0");
        }
        Node temp = head;
        Node previousNode = null;
        for (int i = 0; i < position; i++) {
            previousNode = temp;
            temp = temp.next;
        }
        if(previousNode != null) {
            previousNode.next = temp.next;
            temp.next = null;
            index--;
        }

        return temp.data;
    }

    public int size() {
        return index-1;
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addLast(10);
        sll.addLast(20);
        sll.addLast(30);
        sll.addLast(40);
        sll.addFirst(5);
        sll.addMiddle(25,2);
        System.out.println("After Adding at differnet positions: " + sll);

        //System.out.println("Element Removed : " +sll.removeFirst());
        //sll.removeLast();
        System.out.println("Deleted Middle element : " + sll.removeAt(2));

        System.out.println(sll);
    }

    @Override
    public String toString() {
        Node temp = head;
        count=index;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(temp.next != null) {
            sb.append(temp.data)
            .append(" : ")
            .append(index - count)
            .append(", ");
            temp = temp.next;
            count--;
        }
        sb.append(temp.data)
        .append(" : ")
        .append(index - count)
        .append("]");
        count--;
        return sb.toString();
    }
}