package com.emmanuel.datastructures.queues;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ArrayQueueTest {
    @Test
    void ensureElementIsEnqueued() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("Hey");
        assertFalse(queue.isEmpty());
        assertNotNull(queue.peek());
        assertEquals(3, queue.size());
        assertEquals("Hi", queue.peek());
    }

    @Test
    void ensureElementIsDequeued() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("Hey");
        assertFalse(queue.isEmpty());
        assertNotNull(queue.peek());
        assertEquals("Hi", queue.dequeue());
        assertEquals(2, queue.size());
        assertTrue(queue.toString().contains("Hey"));
    }
}
