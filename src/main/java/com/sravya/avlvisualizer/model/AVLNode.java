package com.sravya.avlvisualizer.model;

public class AVLNode {

    public int value;
    public int height;

    public AVLNode left;
    public AVLNode right;

    public AVLNode(int value) {
        this.value = value;
        this.height = 1;
    }
}