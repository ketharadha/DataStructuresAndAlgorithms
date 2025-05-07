package com.collections;

public class CustomArrayListV1 {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] listArray = {};
    
    private int size;

    //Default Capacity
    public CustomArrayListV1() {
        listArray = new Object[DEFAULT_CAPACITY];
    }
    
    public CustomArrayListV1(int capacity) {
        listArray = new Object[capacity];
    }

    private void add(Object o) {
        int oldCapacity = listArray.length;
        if(size >= oldCapacity) {
            int newcapacity = oldCapacity + oldCapacity /2;
            System.out.println(" New Capacity : " + newcapacity);
            Object[] ar = new Object[newcapacity];
            for (int i = 0; i < oldCapacity ; i++) {
                ar[i] = listArray[i];
            }
            listArray = ar;
            //listArray = Arrays.copyOf(listArray, newcapacity);
        }
        listArray[size] = o;
        size++;
    }

    private Object remove(int index) {
        Object obj = get(index);
        Object[] arr = new Object[size];
        for (int i = 0; i < size-1; i++) {
            if(index < i) {
                arr[i] = listArray[i];
            } else {
                arr[i] = listArray[i+1];
            }
        }

        listArray = arr;
        size--;
        return obj;
    }

    private Object get(int index) {
        if(index < 0 || index >= listArray.length) {
            throw new ArrayIndexOutOfBoundsException("Index should be between 0 and "+ (listArray.length-1));
        }
        return listArray[index];
    }

    public static void main(String[] args) {
        CustomArrayListV1 ca = new CustomArrayListV1(5);
        ca.add(10);
        ca.add(20);
        ca.add(30);
        ca.add(40);
        ca.add(50);
        ca.add(60);

        System.out.println(ca);
        ca.remove(2);
        System.out.println(ca);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < listArray.length-1; i++) {
            if(listArray[i] != null) {
                if(listArray.length-1 == i) {
                    if(listArray[i] != null)
                        sb.append(listArray[i]);
                        //System.out.println(sb.toString());
                } else {
                    if(listArray[i] != null) {
                        sb.append(listArray[i]).append(", ");
                        //System.out.println(sb.toString());
                    }
                }
            }
        } 
        return sb.append("]").toString();
    }    
}
