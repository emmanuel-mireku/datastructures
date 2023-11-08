package com.emmanuel.datastructures.arrays.staticarray;


import com.emmanuel.datastructures.arrays.ArrayInterface;


@SuppressWarnings({"unchecked", "ManualArrayCopy"})
public class StaticArray<T> implements ArrayInterface<T> {
    private T[] array;

    public StaticArray(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException(
                    "Ensure capacity is greater than or equals to 0");
        }
        array = (T[]) new Object[capacity];
    }

    @SafeVarargs
    public StaticArray(int capacity, T... elements) {
        if (capacity < 0 || capacity < elements.length) {
            throw new RuntimeException(
                    "Ensure capacity is greater than or equals to the number of elements");
        }
        array = (T[]) new Object[capacity];
        for(int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
        }
    }

    public int size() {
        return array.length;
    }

    public T get(int index) {
        if (isValidIndex(index)) {
            return array[index];
        }
        throw new IndexOutOfBoundsException(
                String.format("Error accessing index %s. The index should be 0 or less than %s",
                        index, array.length));
    }

    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (null != array[i] && array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void set(int index, T element) {
        if(isValidIndex(index)) {
            array[index] = element;
        }
    }
    private boolean isValidIndex(int index) {
        return index >= 0 && index < array.length;
    }

    public void setArray(StaticArray<T> staticArray) {
        this.array = staticArray.getArray();
    }

    public T[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; ; i++) {
            builder.append(get(i));
            if (i == size() - 1) {
                return builder.append("]").toString();
            }
            builder.append(", ");
        }
    }
}
