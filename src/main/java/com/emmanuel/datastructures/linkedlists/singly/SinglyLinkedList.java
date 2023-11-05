package com.emmanuel.datastructures.linkedlists.singly;

import com.emmanuel.datastructures.linkedlists.LinkedList;

import static com.emmanuel.datastructures.linkedlists.LinkedListConstants.*;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public SinglyLinkedList() {
        first = last = new Node<>();
        size = 0;
    }

    @SafeVarargs
    public SinglyLinkedList(T ...elements) {
        for (T element: elements) {
            link(element);
        }
    }

    @Override
    public int indexOf(T value) {
        Node<T> currentNode = first;
        int index = 0;
        while(null != currentNode) {
            if(value.equals(currentNode.value)) {
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
        if(isValidIndex(index)) {
            if(index == 0) {
                linkFirst(element);
                return;
            }
            Node<T> currentNode = first;
            int increment = 0;
            while(true) {
                if(increment == index - 1) {
                    Node<T> nextNode = currentNode.next;
                    currentNode.next = new Node<>(element, nextNode);
                    size++;
                    return;
                }
                increment++;
                currentNode = currentNode.next;
            }
        }
        throw new IndexOutOfBoundsException(CANNOT_ADD_OUT_OF_BOUNDS);
    }

    @Override
    public void linkFirst(T element) {
        if(isEmpty()) {
            first = last = new Node<>(element);
        } else {
            first = new Node<>(element, first);
        }
        size++;
    }

    @Override
    public void linkLast(T element) {
        if(isEmpty()) {
            first = last = new Node<>(element);
        } else {
            last.next = new Node<>(element);
            last = last.next;
        }
        size++;
    }

    @Override
    public T unlink(int index) {
        if(isValidIndex(index)) {
            if(index == 0) {
                return unlinkFirst();
            }
            if(index == size - 1) {
                return unlinkLast();
            }
            Node<T> previousNode = first;
            int currentIndex = 0;
            while(true) {
                if(currentIndex == index - 1) {
                    Node<T> currentNode = previousNode.next;
                    Node<T> nextNode = currentNode.next;
                    T deletedValue = currentNode.value;
                    currentNode.value = null;
                    previousNode.next = nextNode;
                    size--;
                    return deletedValue;
                }
                currentIndex++;
                previousNode = previousNode.next;
            }
        }
        throw new IndexOutOfBoundsException(DELETION_INVALID_NO_INDEX);
    }

    @Override
    public T unlinkFirst() {
        if(isEmpty()) {
            throw new RuntimeException(DELETION_INVALID_EMPTY_LIST);
        }
        T deletedValue = first.value;
        first = first.next;
        size--;
        return deletedValue;
    }

    @Override
    public T unlinkLast() {
        if(isEmpty()) {
            throw new RuntimeException(DELETION_INVALID_EMPTY_LIST);
        }
        T deletedValue = last.value;
        Node<T> currentNode = first;
        Node<T> nextNode = currentNode.next;
        while(nextNode != null) {
            if(nextNode.equals(last)) {
                last = currentNode;
                size--;
            } else {
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
        }
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

    @Override
    public T getLink(int index) {
        return getNode(index).value;
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

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public void clear() {
        Node<T> currentNode = first;
        while(null != currentNode) {
            currentNode.value = null;
            currentNode = currentNode.next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<T> currentNode = first;
        if(isEmpty()) {
            return output.toString();
        }
        output.append("{HEAD} --> ");
        while(null != currentNode) {
            output.append(currentNode.value).append(" --> ");
            currentNode = currentNode.next;
        }
        return output.append("{TAIL}").toString();
    }
}