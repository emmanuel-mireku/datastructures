package com.emmanuel.datastructures.arrays;

public interface ArrayInterface<T> {
    /**
     * @return the size of the array
     */
    int size();

    /**
     * Returns the element in the array at the given index of the array
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @param index current position of an element in the array
     * @return the element of the specified index
     */
    T get(int index);

    /**
     * Loops through the array to find the given element
     * and return the index of the given element
     * <p>
     * <p>
     * Worst case: O(n)
     *
     * @param element   specific element in the array
     * @return  the index of the element in the array
     */
    int indexOf(T element);

    /**
     * Replaces the existing element in the array
     * with the given element at the given index of the array.
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @param index current position of an element in the array
     * @param element   replacement element
     *
     */
    void set(int index, T element);

    /**
     * Checks the size of the array and
     * returns true if the size of the array is 0
     * <p>
     * Worst case: O(1)
     *
     * @return true if the array is empty
     */
    boolean isEmpty();
}
