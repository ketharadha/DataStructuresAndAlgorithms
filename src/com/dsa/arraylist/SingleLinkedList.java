package com.dsa.arraylist;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class SingleLinkedList {

    private Node head;
    private int nodeIndex = 0;

    private class Node {
        private final Object data;
        private Node next;
        Node(Object data) {
            this.data = data;
        }
    }

    private void addLast(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        nodeIndex++;
        System.out.println("Node Index : " + nodeIndex);
    }

    private void addFirst(Object data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
        } else {
            Node currentNode = head;
            head = node;
            head.next = currentNode;
        }
        nodeIndex++;
        System.out.println("Node Index : " + nodeIndex);
    }
    
    private void addMiddle(Object data, int index) {
        Node node = new Node(data);

        Node currentNode = head;
        int count = 0;
        while (count < index-1) {
            currentNode = currentNode.next;  
            count++;
        }
        Node nextNode = currentNode.next;
        node.next = nextNode;
        currentNode.next = node;
        nodeIndex++;
        System.out.println("Node Index : " + nodeIndex);
    }

    private Node deleteFirst() {
        Node deletedNode = head;
        head = head.next;
        deletedNode.next = null;
        nodeIndex--;
        return deletedNode;
    }

    private boolean deleteNode(Object data) {

        

        return false;
    }

    private void concurrentModificationExcepArrayList() {
        //List<Integer> ll = new ArrayList<>(2);
        List<Integer> ll = new CopyOnWriteArrayList<>();
        ll.add(10);
        ll.add(20);


        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            ll.add(30);
            System.out.println(it.next());
        }
        System.out.println(ll);
    }

    private void concurrentModificationExcepHashMap() {
        //Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new ConcurrentHashMap<>();
        
        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");

        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            map.put(40, "D");
            System.out.println(it.next());
        }
        System.out.println(map);
    }

    private void concurrentModificationExcepHashSet() {
        //Set<Integer> set = new HashSet<>();
        Set<Integer> set = new CopyOnWriteArraySet<>();
        set.add(10);
        set.add(20);
        set.add(30);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            set.add(40);
        }
        System.out.println(set);
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addLast(5);
        sll.addLast(8);
        sll.addFirst(10);
        sll.addLast(6);
        sll.addFirst(10);
        sll.addFirst(14);
        sll.addLast(new Employee(1, "Krishna"));
        sll.addFirst(new Employee(2, "Rajesh"));
        sll.addMiddle(new Employee(3, "ABCD"), 3);
        sll.printLL();

        sll.deleteFirst();
        System.out.println("After deletion" + sll.nodeIndex);
        sll.deleteFirst();
        System.out.println("After deletion" + sll.nodeIndex);
        sll.printLL();

        sll.concurrentModificationExcepArrayList();
        //sll.concurrentModificationExcepHashMap();
        //sll.concurrentModificationExcepHashSet();
    }

    private void printLL() {
        Node currentNode = head;
        int count = 0;
        while(currentNode != null){
            System.out.println("Node " + count + " : " + currentNode.data);
            currentNode = currentNode.next;
            count++;
        }
    }
}
//ShalloCopy vs DeepCopy
//CopyONWriteArrayList
//Difference between Iterator and ListIterator
