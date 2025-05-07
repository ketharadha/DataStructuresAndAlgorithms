package com.dsa.arraylist;

import java.util.Arrays;

public class CustomArrayList {
    private static int DEFAULT_CAPACITY = 10;
    private Object[] list = {};
    private int index;

    public CustomArrayList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        list = new Object[capacity];
    }

    public void add(Object obj) {
        int oldCapacity = list.length;
        if(index >= list.length) {
            int newCapacity = oldCapacity + oldCapacity/2;
            /*Object[] newList = new Object[newCapacity];
            for (int idx = 0; idx < oldCapacity; idx++) {
                newList[idx] = list[idx];
            }
            list = newList;*/
            list = Arrays.copyOf(list, newCapacity);
        }

        list[index] = obj;
        index++;
    }

    public Object get(int idx) {
        if(idx < 0 || idx >= list.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list[idx];
    }

    public Object remove(int idx) {
        Object o = get(idx);
        if (idx < 0 || idx >= list.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] removedList = new Object[index];
        for (int i = 0; i < index; i++) {
            if(i >= idx)
                removedList[i] = list[i+1];
            else 
                removedList[i] = list[i];
        }
        //int leftShiftCount = list.length - idx - 1;
        //System.arraycopy(list, idx+1, list, idx, leftShiftCount);
        list = removedList;
        index--;

        return o;
    }

    public static void main(String[] args) {
        CustomArrayList ca = new CustomArrayList(3);
        ca.add(10);//index = 1
        ca.add(20);//index = 2
        ca.add(30);//index = 3
        ca.add(40);//index = 4
        ca.add(50);// index = 5
        System.out.println("Before Remove : " + ca);

        ca.remove(2);
        System.out.println("After Remove : " + ca);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomArrayList{");
        sb.append("list=").append(Arrays.toString(list));
        sb.append(", index=").append(index);
        sb.append('}');
        return sb.toString();
    }

    


}
