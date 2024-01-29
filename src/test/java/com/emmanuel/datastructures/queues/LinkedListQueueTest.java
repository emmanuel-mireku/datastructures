package com.emmanuel.datastructures.queues;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkedListQueueTest {

    @Test
    void ensureElementIsEnqueued() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("Hey");
        assertFalse(queue.isEmpty());
        assertNotNull(queue.peek());
        assertEquals("Hi", queue.peek());
        assertTrue(queue.toString().contains("Hey"));
    }

    @Test
    void ensureElementIsDequeued() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("Hey");
        assertFalse(queue.isEmpty());
        assertNotNull(queue.peek());
        assertEquals("Hi", queue.dequeue());
        assertEquals(2, queue.size());
    }
}
