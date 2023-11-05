package com.emmanuel.datastructures.linkedlists;

public interface LinkedList<T> {

    /**
     * @return the current size of the linked list.
     */
    int size();

    /**
     * @return a boolean when the list is empty or not empty
     */
    boolean isEmpty();

    /**
     * Appends the given element to the beginning of the list.
     * <p>
     * <p>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(1)
     *
     * @param element value to be appended to the list
     */
    void linkFirst(T element);

    /**
     * Appends the given element to the ending of the list.
     * <p>
     * <p>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(n)
     *
     * @param element value to be appended to the list
     */
    void linkLast(T element);

    /**
     * Appends the given element to the ending of the list.
     * <p>
     * <p>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(n)
     *
     * @param element value to be appended to the list
     */
    void link(T element);

    /**
     * Appends a new link in the list at a given index
     * <p>
     * <p>
     * Doubly linked list Worst case: O(n)
     * Singly linked list Worst case: O(n)
     *
     * @param index current position to add an element into the list
     * @param element value to be appended to the list
     */
    void link(int index, T element);

    /**
     * Returns the first link in the linked list
     * <p>
     * <p>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(1)
     *
     * @return the value of the first element in the list
     */
    T getFirstLink();

    /**
     * Returns the last link in the linked list
     * <p>
     * <p>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(1)
     *
     * @return the value of the last element in the list
     */
    T getLastLink();

    /**
     * Loops through the linked list and return the value of the given index
     * <p>
     * <p>
     * Doubly linked list Worst case: O(n)
     * Singly linked list Worst case: O(n)
     *
     * @param index current position of an element in the linked list
     * @return the value of the given index
     */
    T getLink(int index);

    /**
     * Loops through the linked list and returns the index of the first value
     * <p>
     * <p>
     * Doubly linked list Worst case: O(n)
     * Singly linked list Worst case: O(n)
     *
     * @param value current value in the linked list
     * @return the index of the given value
     */
    int indexOf(T value);

    /**
     * Deletes the first link in the list and returns it value
     * <P>
     * <P>
     * Doubly linked list Worst case: O(1)
     * Singly linked list Worst case: O(1)
     *
     * @return the value of the deleted link
     */
    T unlinkFirst();

    /**
     * Deletes the last link in the list and returns it value
     * <P>
     * <P>
     * Singly linked list worst case: O(n)
     * Doubly linked list worst case: O(1)
     *
     * @return the value of the deleted link
     */
    T unlinkLast();

    /**
     * Loops through the list and deletes a link at a given index
     * <p>
     * <p>
     * Doubly linked list Worst case: O(n)
     * Singly linked list Worst case: O(n)
     *
     * @param index current position in the linked list
     *
     * @return the value of the deleted link
     */
    T unlink(int index);


    /**
     * Deletes all the links of the linked list
     * <p>
     * <p>
     * Doubly linked list Worst case: O(n)
     * Singly linked list Worst case: O(n)
     */
    void clear();

}
