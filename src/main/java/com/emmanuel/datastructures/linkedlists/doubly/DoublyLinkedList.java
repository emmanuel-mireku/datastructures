package com.emmanuel.datastructures.linkedlists.doubly;

import com.emmanuel.datastructures.linkedlists.LinkedList;

import static com.emmanuel.datastructures.linkedlists.LinkedListConstants.*;


public class DoublyLinkedList<T> implements LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoublyLinkedList() {
        first = last = null;
        size = 0;
    }

    @SafeVarargs
    public DoublyLinkedList(T... elements) {
        for (T element : elements) {
            link(element);
        }
    }

    @Override
    public int indexOf(T value) {
        Node<T> currentNode = first;
        int index = 0;
        while (null != currentNode) {
            if (value.equals(currentNode.value)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void link(T element) {
        linkLast(element);
    }

    @Override
    public void link(int index, T element) {
        if (index == 0) {
            linkFirst(element);
        } else {
            insertElementAt(index, element);
        }
    }

    private void insertElementAt(int index, T element) {
        Node<T> currentNode = getNode(index);
        Node<T> previousNode = currentNode.previous;
        Node<T> newNode = new Node<>(previousNode, element, currentNode);
        currentNode.previous = newNode;
        previousNode.next = newNode;
        size++;
    }

    @Override
    public void linkFirst(T element) {
        if (isEmpty()) {
            first = last = new Node<>(null, element, null);
        } else {
            first.previous = new Node<>(null, element, first);
            first = first.previous;
        }
        size++;
    }

    @Override
    public void linkLast(T element) {
        if (isEmpty()) {
            first = last = new Node<>(null, element, null);
        } else {
            last.next = new Node<>(last, element, null);
            last = last.next;
        }
        size++;
    }

    @Override
    public T unlink(int index) {
        if (isValidIndex(index)) {
            if (index == 0) {
                return unlinkFirst();
            }
            if (index == size - 1) {
                return unlinkLast();
            }
            return getDeletedNode(getNode(index));
        }
        throw new IndexOutOfBoundsException(DELETION_INVALID_NO_INDEX);
    }

    private T getDeletedNode(Node<T> currentNode) {
        T deletedValue = currentNode.value;
        updateLinks(currentNode);
        deleteNode(currentNode);
        size--;
        return deletedValue;
    }

    private static <T> void updateLinks(Node<T> currentNode) {
        Node<T> previousNode = currentNode.previous;
        Node<T> nextNode = currentNode.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
    }

    private void deleteNode(Node<T> currentNode) {
        currentNode.value = null;
        currentNode.previous = null;
        currentNode.next = null;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public T unlinkFirst() {
        if (isEmpty()) {
            throw new RuntimeException(DELETION_INVALID_EMPTY_LIST);
        }
        T deletedValue = first.value;
        first = first.next;
        size--;
        return deletedValue;
    }

    @Override
    public T unlinkLast() {
        if (isEmpty()) {
            throw new RuntimeException(DELETION_INVALID_EMPTY_LIST);
        }
        T deletedValue = last.value;
        last = last.previous;
        size--;
        return deletedValue;
    }

    @Override
    public T getFirstLink() {
        return first.value;
    }

    @Override
    public T getLastLink() {
        return last.value;
    }

    private Node<T> getNode(int index) {
        if (isValidIndex(index)) {
            Node<T> currentNode = first;
            int currentIndex = 0;
            while(true) {
                if(currentIndex == index) {
                    return currentNode;
                }
                currentIndex++;
                currentNode = currentNode.next;
            }
        }
        throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS);
    }

    @Override
    public T getLink(int index) {
        return getNode(index).value;
    }

    @Override
    public void clear() {
        Node<T> currentNode = first;
        while (null != currentNode) {
            currentNode.value = null;
            currentNode.previous = null;
            currentNode = currentNode.next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<T> currentNode = first;
        if (isEmpty()) {
            return output.toString();
        }
        output.append("{HEAD} --> ");
        while (null != currentNode) {
            output.append("<-- ").append(currentNode.value).append(" --> ");
            currentNode = currentNode.next;
        }
        return output.append("{TAIL}").toString();
    }

}
