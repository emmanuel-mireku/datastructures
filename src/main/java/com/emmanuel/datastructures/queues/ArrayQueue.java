package com.emmanuel.datastructures.queues;

import com.emmanuel.datastructures.arrays.dynamicarray.DynamicArray;

public class ArrayQueue<T> implements Queue<T> {
    private final DynamicArray<T> array;

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T element) {
        array.add(element);
    }

    @Override
    public T dequeue() {
        return array.deleteAt(0);
    }

    @Override
    public T peek() {
        return array.get(0);
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
