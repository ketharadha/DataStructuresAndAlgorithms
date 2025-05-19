package com.collections;

/**
 * ArrayList is implemented using Object array. 
 * When the arraylist max out it's initial capacity it automatically 
 * increases it capacity and allow to add more elements.
 * This is done my create a fresh new array with larger capacity, copy the elements into the new array.
 */
public class CustomArrayList {

    private static int DEFAULT_CAPACITY = 10;
    Object[] objectArray = {};
    int index;

    
    public CustomArrayList(){
        objectArray = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int initialCapacity) {
        objectArray = new Object[initialCapacity];
    }
    
    public void add(Object o) {
        if(o == null) {
            throw new IllegalArgumentException("The element should not be null");
        }
        
        if(index >= objectArray.length) {
            int newCapacity = this.grow(objectArray.length);
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < objectArray.length; i++) {
                newArray[i] = objectArray[i];
            }
            //System.arraycopy(objectArray, 0, newArray, 0, objectArray.length);
            objectArray = newArray;
        }
        objectArray[index] = o;
        index++;
    }

    //Array list grows by 50% percent. It is 100% for Vector.
    private int grow(int initialCapacity) {
        return initialCapacity + initialCapacity/2;
    }

    public Object get(int i) {
        if(i < 0 || i >= index) { //Important condition to handle
            throw new IndexOutOfBoundsException("Invlaid index " + i);
        }
        return objectArray[i];
    }

    public int size() {
        return index;
    }

    public Object remove(int idx) {
        Object o1 = get(idx);
        Object[] o = new Object[index];
        for (int i = 0; i < index-1 ; i++) {
            if(i < idx) {
                o[i] = objectArray[i];
            } else {
                o[i] = objectArray[i+1];
            }
        }
        objectArray = o;
        index--;

        return o1;
    }

    public Object removeWithArrayCopy(int indexToBeDeleted) {
        Object obj = get(indexToBeDeleted);
        int numberOfShifts = objectArray.length - indexToBeDeleted - 1;
        System.arraycopy(objectArray, indexToBeDeleted+1, 
                        objectArray, indexToBeDeleted, 
                        numberOfShifts);
        return obj;
    }

    public boolean removeByObject(Object obj) {
        for (int i = 1; i < objectArray.length; i++) {
            Object previous = objectArray[i-1];
            if(objectArray[i].equals(obj)) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        CustomArrayList ca = new CustomArrayList();
        ca.add(10);
        ca.add(20);
        ca.add(30);
        ca.add(40);
        ca.add(50);
        ca.add(60);
        ca.add(70);
        ca.add(80);
        
       System.out.println(ca);
       ca.removeWithArrayCopy(2);
       System.out.println(ca);

       System.out.println("Object Array Length : " + ca.size());
    }

    /*@Override
    public String toString() {
        return "CustomArrayList [" +Arrays.toString(objectArray) + "]";
    }*/

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append("[");
        for (int i = 0; i < objectArray.length; i++) {
            if(i==(objectArray.length-1)) {
                if(null!=objectArray[i])
                    s.append(objectArray[i]);
            } else {
                s.append(objectArray[i]);
                if(null!=objectArray[i]) {
                    if(i==(objectArray.length-1)) {
                        s.append(objectArray[i]);
                    }else {
                        s.append(objectArray[i]+", ");
                    }
                }
            }
        }
        s.append("]");
        return s.toString();
    }
    
    public void actualArrayList() {
        
    }
}
