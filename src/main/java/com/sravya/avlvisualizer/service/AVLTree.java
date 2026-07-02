package com.sravya.avlvisualizer.service;

import com.sravya.avlvisualizer.model.AVLNode;
import org.springframework.stereotype.Service;

@Service
public class AVLTree {

    private AVLNode root;
    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    private int max(int a, int b) {
        return Math.max(a, b);
    }
    private int getBalance(AVLNode node) {

        if (node == null)
            return 0;

        return height(node.left) - height(node.right);

    }
    private AVLNode rightRotate(AVLNode y) {

        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }
    private AVLNode leftRotate(AVLNode x) {

        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }
    public void insert(int value) {
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode node, int value) {

        // Normal BST
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }
        node.height = 1 + max(height(node.left), height(node.right));

        // Get balance factor
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        // RR Case
        if (balance < -1 && value > node.right.value) {
            return leftRotate(node);
        }

        // LR Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    public AVLNode getRoot() {
        return root;
    }
    public void delete(int value) {
        root = delete(root, value);
    }
    private AVLNode minValueNode(AVLNode node) {

        AVLNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    private AVLNode delete(AVLNode root, int value) {

        if (root == null)
            return root;

        // BST Delete
        if (value < root.value) {

            root.left = delete(root.left, value);

        } else if (value > root.value) {

            root.right = delete(root.right, value);

        } else {

            // Node with one or no child
            if ((root.left == null) || (root.right == null)) {

                AVLNode temp;

                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                if (temp == null) {

                    root = null;

                } else {

                    root = temp;

                }

            }

            // Node with two children
            else {

                AVLNode temp = minValueNode(root.right);

                root.value = temp.value;

                root.right = delete(root.right, temp.value);

            }

        }

        // Tree had only one node
        if (root == null)
            return root;

        // Update height
        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // LL
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) {

            root.left = leftRotate(root.left);

            return rightRotate(root);

        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) {

            root.right = rightRotate(root.right);

            return leftRotate(root);

        }

        return root;
    }

}
