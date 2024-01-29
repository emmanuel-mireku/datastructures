package com.emmanuel.datastructures.queues;

import com.emmanuel.datastructures.linkedlists.doubly.DoublyLinkedList;

public class LinkedListQueue<T> implements Queue<T> {
    private final DoublyLinkedList<T> list;

    public LinkedListQueue() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T element) {
        list.linkLast(element);
    }

    @Override
    public T dequeue() {
        return list.unlinkFirst();
    }

    @Override
    public T peek() {
        return list.getFirstLink();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; ; i++) {
            builder.append(list.getLink(i));
            if (list.size() - 1 == i) {
                return builder.append("]").toString();
            }
            builder.append(", ");
        }
    }
}
