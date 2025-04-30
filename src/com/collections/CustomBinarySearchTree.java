package com.collections;

import com.sun.jdi.connect.Connector;

public class CustomBinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node temp = root; 
            while(true) {
                if(data == temp.data) {
                    return;
                }
                if (data < temp.data) {
                    if(temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = node;
                        return;
                    }
                } else {
                    if (temp.right != null) {
                        temp = temp.right;
                    } else {
                        temp.right = node;
                        return;
                    }
                }
            }
        }
    }
    
    private void inOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root) {
        if(root != null) {
            System.out.println(root.data);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    private void postOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    private int minValue(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int maxValue(Node root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    private String findNode(Node root, int value) {
        while(true) {
            if(root != null) {
                if (value == root.data) {
                    return "Found Node : " + root.data;
                }
                if (value < root.data) {
                    System.out.println("Accessing Left Node : " + root.data);
                    root = root.left;
                } else {
                    System.out.println("Accessing Right Node : " + root.data);
                    root = root.right;
                }
            } else {
                return "Node Not Found : " + value;
            }
        }
    }

    private boolean findNodeWithRecursion(Node root, int value) {
        
        if(root != null) {
            if (value == root.data) {
                return true;
            }else if (value < root.data) {
                return findNodeWithRecursion(root.left, value);
            } else {
                return findNodeWithRecursion(root.right, value);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CustomBinarySearchTree cbt = new CustomBinarySearchTree();

        cbt.add(50);
        cbt.add(45);
        cbt.add(55);
        cbt.add(51);
        cbt.add(40);
        cbt.add(10);
        /*System.out.println("Inorder Traveral");
        cbt.inOrderTraversal(cbt.root);
        System.out.println("PreOrder Traversal");
        cbt.preOrderTraversal(cbt.root);
        System.out.println("PostOrder Traversal");
        cbt.postOrderTraversal(cbt.root);*/
        //Find the min value of binary tree
        System.out.println("Minimum Value : " + cbt.minValue(cbt.root));
        System.out.println("Maximum Value : " + cbt.maxValue(cbt.root));
        System.out.println(cbt.findNode(cbt.root, 51));
        System.out.println(cbt.findNode(cbt.root, 54));
        System.out.println(cbt.findNodeWithRecursion(cbt.root, 51));
        System.out.println(cbt.findNodeWithRecursion(cbt.root, 54));
    }
}
