package com.emmanuel.datastructures.stacks.linkedliststack;

import com.emmanuel.datastructures.linkedlists.singly.SinglyLinkedList;
import com.emmanuel.datastructures.stacks.Stack;
import com.emmanuel.datastructures.stacks.StackUnderFlowError;

public class LinkedListStack<T> implements Stack<T> {
    public final static int DEFAULT_INITIAL_CAPACITY = 12;
    private final SinglyLinkedList<T> linkedList;
    private final int capacity;

    public LinkedListStack() {
        capacity = DEFAULT_INITIAL_CAPACITY;
        linkedList = new SinglyLinkedList<>();
    }

    public LinkedListStack(int capacity) {
        if (isValidCapacity(capacity)) {
            this.capacity = capacity;
        } else {
            this.capacity = DEFAULT_INITIAL_CAPACITY;
        }
        linkedList = new SinglyLinkedList<>();
    }

    @Override
    public void push(T value) {
        if (linkedList.size() < capacity) {
            linkedList.linkFirst(value);
        } else {
            throw new StackOverflowError();
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderFlowError();
        }
        return linkedList.unlinkFirst();
    }

    @Override
    public T peek() {
        return linkedList.getFirstLink();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    private boolean isValidCapacity(int capacity) {
        return capacity > 0;
    }


}
