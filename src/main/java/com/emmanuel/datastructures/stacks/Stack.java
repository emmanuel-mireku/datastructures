package com.emmanuel.datastructures.stacks;

public interface Stack<T> {
    /**
     * Inserts an element at the top of the stack
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @param value element to be inserted onto the stack
     */
    void push(T value);

    /**
     * Deletes an element from the top of the stack
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @return the deleted element on top of the stack
     */
    T pop();

    /**
     * Returns the current element on top of the stack
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @return the element at the top of the stack
     */
    T peek();

    /**
     * Checks the stack to see if it is empty
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @return weather the stack is empty or not
     */
    boolean isEmpty();

    /**
     * Returns the size of the stack
     * <p>
     * <p>
     * Worst case: O(1)
     *
     * @return the size of the stack
     */
    int size();
}
