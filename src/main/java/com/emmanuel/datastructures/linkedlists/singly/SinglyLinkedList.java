package com.emmanuel.datastructures.linkedlists.singly;

import com.emmanuel.datastructures.linkedlists.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        tail = head;
        size++;
        while(null != this.head.next) {
            tail = this.head.next;
            size++;
            this.head = this.head.next.next;
        }
    }
    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Node<T> node) {
       addNode(node);
    }

    private void addNode(Node<T> currentNode) {
        if(null == currentNode) {
            return;
        }
        if(null == head) {
            head = currentNode;
            size++;
        }
        head.next = currentNode;
        tail = null == currentNode.next ? head : currentNode.next;
        size++;
        if(null != head.next.next) {
            addNode(head.next.next);
        }
    }

    @Override
    public void insertAtHed() {

    }

    @Override
    public void insertAtTail() {

    }

    @Override
    public void set() {

    }

    @Override
    public T delete(T value) {
        return null;
    }

    @Override
    public T deleteFirst() {
        return null;
    }

    @Override
    public T deleteLast() {
        return null;
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
    }

    @Override
    public Node<T> get(T value) {
        return null;
    }

    @Override
    public void clear() {

    }
}
