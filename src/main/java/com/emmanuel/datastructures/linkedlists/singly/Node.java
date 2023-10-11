package com.emmanuel.datastructures.linkedlists.singly;

public class Node<T> {
    Node<T> next;
    T value;

    public Node() {
        value = null;
        next = null;
    }

    public Node(T value) {
        this.value = value;
        next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
