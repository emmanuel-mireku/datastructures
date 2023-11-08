package com.emmanuel.datastructures.stacks.arraystack;

import com.emmanuel.datastructures.arrays.staticarray.StaticArray;
import com.emmanuel.datastructures.stacks.Stack;
import com.emmanuel.datastructures.stacks.StackUnderFlowError;

public class ArrayStack<T> implements Stack<T> {
    public final static int DEFAULT_INITIAL_CAPACITY = 12;
    private final StaticArray<T> array;
    private final int capacity;
    private int currentIndex;

    public ArrayStack() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        array = new StaticArray<>(this.capacity);
        currentIndex = 0;
    }

    public ArrayStack(int capacity) {
        if (isValidCapacity(capacity)) {
            this.capacity = capacity;
        } else {
            this.capacity = DEFAULT_INITIAL_CAPACITY;
        }
        array = new StaticArray<>(capacity);
        currentIndex = 0;
    }


    @Override
    public void push(T value) {
        if (currentIndex <= array.size() - 1) {
            array.set(currentIndex, value);
            currentIndex++;
        } else {
            throw new StackOverflowError();
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderFlowError();
        }
        T deletedElement = array.get(currentIndex - 1);
        array.set(currentIndex - 1, null);
        currentIndex--;
        return deletedElement;
    }

    @Override
    public T peek() {
        return array.get(currentIndex - 1);
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return array.toString();
    }

    private boolean isValidCapacity(int capacity) {
        return capacity > 0;
    }
}
