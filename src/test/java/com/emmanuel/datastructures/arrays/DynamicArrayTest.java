package com.emmanuel.datastructures.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DynamicArrayTest {
    public static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(4, new Integer[]{2, 7, 8, 9}),
                Arguments.of(4, new String[]{"Hi", "Hello", "Maakye", "Ciao"}),
                Arguments.of(4, new Character[]{'A', 'B', 'C', 'D'}),
                Arguments.of( 5, new Double[]{1.5, 2.0, 7.9, 8.3, 9.33}));
    }

    @ParameterizedTest
    @MethodSource("validParameters")
    void ensureDynamicArrayIsInstantiatedAccurately(int capacity, Object... elements) {
        DynamicArray<Object> dynamicArray = new DynamicArray<>(capacity, elements);
        assertEquals(capacity, dynamicArray.size());
        assertNotNull(dynamicArray.get(0));
    }

    @Test
    void ensureDynamicArrayIsInstantiatedWithDefaultCapacity() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        assertEquals(0, dynamicArray.size());
    }

    @Test
    void ensureNewElementIsAppendedSuccessfully() {
        DynamicArray<String> dynamicArray = new DynamicArray<>(1);
        dynamicArray.add("Hello");
        dynamicArray.add("Hey");
        assertEquals(0, dynamicArray.indexOf("Hello"));
        assertEquals(1, dynamicArray.indexOf("Hey"));
        assertEquals(2, dynamicArray.size());
    }

    @Test
    void ensureNewElementIsAddedSuccessfully() {
        DynamicArray<String> dynamicArray = new DynamicArray<>("Hi");
        dynamicArray.add("Hello");
        assertEquals(2, dynamicArray.size());
    }

    @Test
    void ensureNewElementIsInsertedAtTheCorrectPosition() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.insertAt(3, "Hello");
        assertEquals(3, dynamicArray.indexOf("Hello"));
        assertEquals(5, dynamicArray.size());
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>(1);
        integerDynamicArray.insertAt(1, 1);
        assertEquals(1, integerDynamicArray.get(0));

    }

    @Test
    void ensureInvalidInsertionThrowsException() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insertAt(3000, "Howdy"));
    }

    @Test
    void ensureElementIsDeleted() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("Hello");
        dynamicArray.delete("Hello");
        assertEquals(-1, dynamicArray.indexOf("Hello"));
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add("Hello");
        dynamicArray.add("Maakye");
        dynamicArray.add("Hey");
        dynamicArray.add("Howdy");
        dynamicArray.add("sup");
        dynamicArray.delete("Maakye");
        String deletedElement = dynamicArray.deleteAt(3);
        assertEquals("Howdy", deletedElement);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(3, dynamicArray.size());
    }

    @Test
    void ensureInvalidDeletionThrowsException() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("Hello");
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.delete("sup"));
    }

    @Test
    void ensureElementsAreCleared() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.clear();
        assertEquals(0, dynamicArray.size());
    }
}
