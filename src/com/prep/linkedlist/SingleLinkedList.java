package com.prep.linkedlist;

import com.prep.util.Printer;

public class SingleLinkedList {
    private ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void printLinkListElements(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.data + " --> ");
            listNode = listNode.next;
        }
    }

    private int getLinkListSize(ListNode listNode) {
        int size = 0;
        while(listNode != null) {
            size++;
            listNode = listNode.next;
        }
        return size;
    }

    private ListNode addFrontOfList(int value) {
        /* ListNode temp = head;
        head = listNode;
        head.next = temp;
        return head; */
        ListNode frontNode = new ListNode(value);
        frontNode.next = head;
        head = frontNode;
        return head;
    }

    private void addEndOfList(int value) {
        ListNode listNode = new ListNode(value);
        if(head == null) {
            head = listNode;
            return;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = listNode;
    }

    public void insertNodeAt(int position, int value) {
        ListNode listNode = new ListNode(value);
        if (position == 1) {
            listNode.next = head;
            head = listNode;
        } else {
            ListNode previous = head;
            /*for(int count = 1; count < position - 1; count++) {
                previous = previous.next;
            }*/
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode currNode = previous.next;
            previous.next = listNode;
            listNode.next = currNode;
        }
    }

    public void insert(int position, int value) {
        ListNode listNode = new ListNode(value);
        if(position == 1) {
            listNode.next = head;
            head = listNode;
        } else {
            ListNode previousListNode = head;
            int count = 1;
            while (count < position - 1) {
                previousListNode = previousListNode.next;
                count ++;
            }
            ListNode currentListNode = previousListNode.next;
            listNode.next = currentListNode;
            previousListNode.next = listNode;
        }
    }

    //Deletes first node and returns it. 
    //Make sure it's next is poiting to null and not head.
    public ListNode deleteFirst() {
        if (head == null) {
            System.out.println("There are no elements ito delete");
            return null;
        } else {
            //4 --> 5 --> 6 --> 1 --> null
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode currentNode = head;
            ListNode previous = null;
            while (currentNode.next != null) {
                previous = currentNode;
                currentNode = currentNode.next;
            }
            previous.next = null;
            return currentNode;
        }
    }

    public ListNode deleteAt(int position) {
        //4 --> 9 --> 8 --> 11 --> 14 --> null
        if (position == 1) {
            head = head.next;
            return head;
        } else {
            int count = 1;
            ListNode previous = head;
            while(count < position - 1) {
                previous = previous.next;
                count ++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
            return current;
        }
    }

    public boolean find(ListNode head, int element) {
        ListNode current = head;
        while (current != null) { //Why not current.next and current in this condition? Because it needs to search against the last node as well.
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        SingleLinkedList sll = new SingleLinkedList();
        /* sll.head = new ListNode(10);
        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(11);
        ListNode fourthNode = new ListNode(6);
        sll.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode; */

        //Print Linked List Elelments.
        //sll.printLinkListElements(sll.head);

        //Print Linked List Size.
        //printer.printInt(sll.getLinkListSize(sll.head));

        //Add To Front Of the Linked list
        /* sll.addFrontOfList(12);
        sll.addFrontOfList(10);
        sll.addFrontOfList(1);
        sll.addFrontOfList(12);
        sll.addFrontOfList(18);
        sll.printLinkListElements(sll.head); */

        sll.addEndOfList(10);
        sll.addEndOfList(12);
        sll.addEndOfList(1);
        sll.addEndOfList(14);
        sll.addEndOfList(15);
        sll.addEndOfList(16);
        sll.printLinkListElements(sll.head);

        System.out.println("\n \n");
        /* try {
            sll.insert(3, 25);
            sll.printLinkListElements(sll.head);
        } catch (NullPointerException e) {
            System.out.println("Invalid postion to insert an element \n" + e);
        } */

        //sll.deleteFirst();
        //sll.deleteLast();
        //sll.deleteAt(4);
        //sll.printLinkListElements(sll.head);

        if(sll.find(sll.head,16)) {
            System.out.println("Search Key Found!!!");
        } else {
            System.out.println("Search key not found");
        }
    }
}
