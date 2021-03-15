package com.DataStructure.Tree;


public class RBNode<T extends Comparable<T>> {
    // Color
    boolean color;

    //key
    T key;
    // left and right son node
    RBNode<T> left;
    RBNode<T> right;
    // parent node
    RBNode<T> parent;

    public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getKey(){
        return key;
    }

    public String toString(){
        return "" + key + (this.color == true ? "R" : "B");
    }

}
