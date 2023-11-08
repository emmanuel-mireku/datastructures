package com.emmanuel.datastructures.arrays.staticarray;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class StaticArrayTest {

    public static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(20, new Integer[]{2, 7, 8, 9}),
                Arguments.of(4, new String[]{"Hi", "Hello", "Maakye", "Ciao"}),
                Arguments.of(13, new Character[]{'A', 'B', 'C', 'D'}),
                Arguments.of( 20, new Double[]{2.0, 7.9, 8.3, 9.33}));
    }

    public static Stream<Arguments> invalidParametersWithIncorrectCapacity() {
        return Stream.of(
                Arguments.of( 1, new Integer[]{2, 7, 8, 9}),
                Arguments.of( 3, new String[]{"Hi", "Hello", "Maakye", "Ciao"}),
                Arguments.of( -5, new Character[]{'A', 'B', 'C', 'D'}),
                Arguments.of( 0, new Double[]{2.0, 7.9, 8.3, 9.33}));
    }

    public static Stream<Arguments> ParametersWithOutOfBoundsIndex() {
        return Stream.of(
                Arguments.of( 4, 4, new Integer[]{2, 7, 8, 9}),
                Arguments.of( 7, -35, new String[]{"Hi", "Hello", "Maakye", "Ciao"}),
                Arguments.of( 8, 25, new Character[]{'A', 'B', 'C', 'D'}),
                Arguments.of( 10, 11, new Double[]{2.0, 7.9, 8.3, 9.33}));
    }

    public static Stream<Arguments> parametersWithExcludedElements() {
        Integer excludedInteger = 9;
        String excludedString = "Maakye";
        Character excludedCharacter = 'E';
        Double excludedDouble = 7.9;
        return Stream.of(
                Arguments.of( 4, excludedInteger, 3, new Integer[]{2, 7, 8, 9}),
                Arguments.of( 7, excludedString, 2, new String[]{"Hi", "Hello", "Maakye", "Ciao"}),
                Arguments.of( 8, excludedCharacter, -1, new Character[]{'A', 'B', 'C', 'D'}),
                Arguments.of( 10, excludedDouble, 1, new Double[]{2.0, 7.9, 8.3, 9.33}));
    }

    @ParameterizedTest
    @MethodSource("validParameters")
    void ensureStaticArrayIsCreatedWithTheCorrectCapacity(
            int capacity, Object... elements) {
        StaticArray<Object> array = new StaticArray<>(capacity, elements);
        StaticArray<Object> anotherArray = new StaticArray<>(capacity);
        assertEquals(capacity, array.size());
        assertEquals(capacity, anotherArray.size());
        assertNotNull(array.get(0));
        assertNull(anotherArray.get(0));
        assertFalse(array.isEmpty());
        assertFalse(anotherArray.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("invalidParametersWithIncorrectCapacity")
    void ensureRuntimeExceptionIsThrownWhenCapacityIsLessThanElements(
            int capacity, Object... elements) {
        assertThrows(RuntimeException.class, () -> new StaticArray<>(capacity, elements));
    }

    @Test
    void ensureRuntimeExceptionIsThrownWhenCapacityIsInvalid() {
        assertThrows(RuntimeException.class, () -> new StaticArray<>(-1));
    }

    @ParameterizedTest
    @MethodSource("ParametersWithOutOfBoundsIndex")
    void ensureIndexOutOfBoundsIsThrownWhenAccessingInvalidIndex(
           int capacity, int index, Object... elements) {
        StaticArray<Object> array = new StaticArray<>(capacity, elements);
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(index));
    }

    @ParameterizedTest
    @MethodSource("parametersWithExcludedElements")
    void ensureTheCorrectIndexIsReturnedForSearch(
            int capacity, Object searchedItem, int expectedIndex, Object... elements) {
        StaticArray<Object> array = new StaticArray<>(capacity, elements);
        assertEquals(expectedIndex, array.indexOf(searchedItem));
    }

    @Test
    void ensureStaticArrayIsEmpty() {
        StaticArray<Integer> array = new StaticArray<>(0);
        assertTrue(array.isEmpty());
    }

    @Test
    void ensureIndexIsUpdatedWithNewElement() {
        StaticArray<String> array = new StaticArray<>(1);
        array.set(0, "Hi");
        assertEquals("Hi", array.get(0));
    }

    @Test
    void ensureInvalidIndexIsIgnoredDuringSet() {
        StaticArray<String> array = new StaticArray<>(1, "Hey");
        array.set(35, "Hi");
        assertEquals("Hey", array.get(0));
    }

    @Test
    void ensureArrayIsSetAndUpdated() {
        StaticArray<String> array = new StaticArray<>(2);
        StaticArray<String> otherArray = new StaticArray<>(3,"The", "Them", "They");
        array.setArray(otherArray);
        assertEquals(3, array.size());
    }

}
