package com.emmanuel.datastructures.linkedlists.doubly;

public class Node<T> {
    Node<T> previous;
    Node<T> next;
    T value;

    public Node(Node<T> previous, T value, Node<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }
}
