package com.emmanuel.datastructures.stacks.linkedliststack;

import com.emmanuel.datastructures.stacks.StackUnderFlowError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LinkedListStackTests {
    @Test
    void ensureElementIsPushed() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void ensureElementIsPopped() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(4, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void ensurePeekReturnsTheCorrectElement() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.peek());
        assertEquals(5, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void ensureStackUnderFlowIsThrownWhenPoppingAnEmptyStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(0);
        assertEquals(LinkedListStack.DEFAULT_INITIAL_CAPACITY, stack.getCapacity());
        assertThrows(StackUnderFlowError.class, stack::pop);
    }

    @Test
    void ensureStackOverFlowIsThrownWhenPushingOntoAFullStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertThrows(StackOverflowError.class, () -> stack.push(50));
    }

    @Test
    void ensureStackIsPrinted() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertNotNull(stack.toString());
        assertNotEquals("", stack.toString());
    }
}
