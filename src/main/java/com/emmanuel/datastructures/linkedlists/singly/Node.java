package com.emmanuel.datastructures.linkedlists.singly;

public class Node<T> {
    public Node<T> next;
    public T value;

    public Node() {
        next = null;
        value = null;
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
