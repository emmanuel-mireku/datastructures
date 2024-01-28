package com.emmanuel.datastructures.arrays.dynamicarray;

import com.emmanuel.datastructures.arrays.staticarray.StaticArray;

public class DynamicArray<T> extends StaticArray<T> implements DynamicArrayInterface<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private int currentPosition;
    private int currentSize;
    private int capacity;

    public DynamicArray() {
        super(DEFAULT_INITIAL_CAPACITY);
        currentPosition = currentSize = 0;
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public DynamicArray(int capacity) {
        super(capacity);
        currentPosition = 0;
        currentSize = 0;
        this.capacity = capacity;
    }

    @SafeVarargs
    public DynamicArray(T... elements) {
        super(elements.length << 1, elements);
        currentPosition = elements.length - 1;
        currentSize = elements.length;
        capacity = currentSize << 1;
    }

    @SafeVarargs
    public DynamicArray(int capacity, T... elements) {
        super(capacity, elements);
        this.capacity = capacity;
        currentPosition = elements.length - 1;
        currentSize = elements.length;
    }

    public void add(T element) {
        if (isValidIndex(size())) {
            set(currentSize, element);
            currentPosition = currentSize;
            currentSize += 1;
        } else {
            append(element);
        }
    }

    private void append(T element) {
        int previousSize = currentSize;
        capacity <<= 1;
        StaticArray<T> newStaticArray = new StaticArray<>(capacity);
        int i = 0;
        while (i < previousSize) {
            newStaticArray.set(i, get(i));
            i++;
        }
        currentPosition = currentSize;
        currentSize = size() + 1;
        setArray(newStaticArray);
        set(currentPosition, element);
    }

    public void delete(T element) {
        deleteAt(indexOf(element));
    }

    public void insertAt(int position, T element) {
        if (capacity == position) {
            append(element);
        } else if (isValidIndex(position)) {
            currentPosition = currentSize;
            currentSize += 1;
            StaticArray<T> newArray = new StaticArray<>(capacity);
            newArray.set(position, element);
            int i = 0;
            while (i < size()) {
                if (position == i) {
                    i += 1;
                } else {
                    newArray.set(i, get(i));
                }
                i++;
            }
            setArray(newArray);
        } else {
            throw new IndexOutOfBoundsException(
                    "Position is not within range");
        }
    }

    @Override
    public T deleteAt(int position) {
        StaticArray<T> newArray = new StaticArray<>(capacity);
        if (isValidIndex(position)) {
            int j = 0;
            int i = 0;
            while (i < super.size() - 1) {
                if (position == i) {
                    j += 1;
                }
                newArray.set(i, get(j));
                i++;
                j++;
            }
            T deletedElement = get(position);
            setArray(newArray);
            currentPosition--;
            currentSize--;
            return deletedElement;
        } else {
            throw new IndexOutOfBoundsException(
                    "Element's position is not within range");
        }
    }

    public void clear() {
        setArray(new StaticArray<>(capacity));
        currentPosition = currentSize = 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; ; i++) {
            builder.append(get(i));
            if (currentSize - 1 == i) {
                return builder.append("]").toString();
            }
            builder.append(", ");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < capacity;
    }

}
