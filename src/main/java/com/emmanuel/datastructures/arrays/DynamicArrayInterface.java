package com.emmanuel.datastructures.arrays;

public interface DynamicArrayInterface<T> extends ArrayInterface<T> {
    /**
     * Adds an element to the array.
     * This increase the size of the array
     * when necessary which allows the array
     * to grow as needed.
     * <p>
     * <p>
     * Average case: O(1) <br>
     * The average case is usually constant because
     * a default capacity that is generous enough is allocated for the array
     * when instantiated initially. This allows the add method to insert
     * at an index which is a constant operation
     * <p>
     * <p>
     * Worst case: O(n) <br>
     * Worst case is linear because a new static array is created when the underlying capacity
     * is full and the full static array elements are copied over into the newly created array
     *
     * @param element element to be added inside the dynamic array
     */
    void add(T element);

    /**
     * Deletes the given element from the array
     * <p>
     * <p>
     * Worst case: O(n) <br>
     * Worst case is linear because this loops through the array to find
     * the given element to remove it from the array. This creates a new array
     * without the element that is going to be deleted; this involves copying
     * over the elements that are not going to be deleted which will take n operations
     * as well
     *
     * @param element element to be removed from the dynamic array
     */
    void delete(T element);

    /**
     * Deletes the element at given index from the array
     * <p>
     * <p>
     * Worst case: O(n) <br>
     * Worst case is linear because this finds the element at the
     * given index to remove it from the array. This creates a new array
     * without the element that is going to be deleted; this involves copying
     * over the elements that are not going to be deleted which will take n operations
     * The finding of the element will not take n operations because of the given index.
     *
     * @param position  the position of the element to be deleted within the dynamic array
     * @return the deleted element at the given position
     */
    T deleteAt(int position);

    void insertAt(int position, T element);
}
