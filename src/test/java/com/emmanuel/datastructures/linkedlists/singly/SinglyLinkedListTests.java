package com.emmanuel.datastructures.linkedlists.singly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SinglyLinkedListTests {
    @Test
    void ensureSinglyLinkedListIsInstantiatedAccurately() {
        Node<String> node = new Node<>("Hi");
        SinglyLinkedList<String> list = new SinglyLinkedList<>(node);
        assertFalse(list.isEmpty());
        assertNotNull(list.head());
        assertNotNull(list.tail());
        assertEquals("Hi", list.head().value);
        assertEquals("Hi", list.tail().value);
        assertEquals(1, list.size());
    }

    @Test
    void ensureSinglyLinkedListWithMultipleNodesIsInstantiatedAccurately() {
        Node<String> node = new Node<>("Hi", new Node<>("Hey"));
        SinglyLinkedList<String> list = new SinglyLinkedList<>(node);
        assertFalse(list.isEmpty());
        assertNotNull(list.head());
        assertNotNull(list.tail());
        assertEquals("Hi", list.head().value);
        assertEquals("Hey", list.tail().value);
        assertEquals(2, list.size());
    }

    @Test
    void ensureNextNodeIsAddedCorrectly() {
        Node<Integer> node = new Node<>();
        node.value = 50;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(node);
        list.add(new Node<>(2));
        list.add(node);
        list.add(node);
        assertFalse(list.isEmpty());
        assertNotNull(list.head());
        assertNotNull(list.tail());
        assertEquals(50, list.head().value);
//        assertEquals(3, list.tail().value);
        assertEquals(5, list.size());

    }

    @Test
    void someTest() {
//        for(int i = 0; i < 7; i++) {
//            System.out.println("post --> " + i);
//            int b = i + 1;
//            System.out.println("After post --> " + b);
//        }
//        System.out.println("\n");
//        System.out.println("\n");
//        System.out.println("\n");
//        for(int i = 0; i < 7; ++i) {
//            System.out.println("Pre --> " + i);
//            int b = i + 1;
//            System.out.println("After Pre --> " + b);
//        }

        int a = 1;
        int b = a++;
        System.out.println("a: " + a + ", b: " + b);
        int j = 0;
        int temp;
        temp = j;
        j++;
        
//        int c = ++a;
//        System.out.println("a: " + a + ", c: " + c);
//        int d = 1;
//        d += a;
//        System.out.println("a: " + a + ", d: " + d);
    }
}
