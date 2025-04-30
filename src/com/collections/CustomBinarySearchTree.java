package com.collections;

import java.lang.runtime.TemplateRuntime;

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

    public static void main(String[] args) {
        CustomBinarySearchTree cbt = new CustomBinarySearchTree();

        cbt.add(50);
        cbt.add(45);
        cbt.add(55);
        cbt.add(51);
        cbt.add(40);
        cbt.add(10);
        System.out.println("Inorder Traveral");
        cbt.inOrderTraversal(cbt.root);
        System.out.println("PreOrder Traversal");
        cbt.preOrderTraversal(cbt.root);
        System.out.println("PostOrder Traversal");
        cbt.postOrderTraversal(cbt.root);
        //Find the min value of binary tree
        System.out.println("Minimum Value : " + cbt.minValue(cbt.root));
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
}
