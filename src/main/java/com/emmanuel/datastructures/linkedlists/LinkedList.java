package com.emmanuel.datastructures.linkedlists;

import com.emmanuel.datastructures.linkedlists.singly.Node;

public interface LinkedList<T> {
    int indexOf(T value);
    int size();
    boolean isEmpty();
    void add(Node<T> node);
    void insertAtHed();
    void insertAtTail();
    void set();
    T delete(T value);
    T deleteFirst();
    T deleteLast();
    Node<T> head();
    Node<T> tail();
    Node<T> get(T value);
    void clear();

}
