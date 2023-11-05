package com.emmanuel.datastructures.linkedlists.doubly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DoublyLinkedListTests {
    public static Stream<Arguments> indexAndExpectedValue() {
        return Stream.of(
                Arguments.of(0, "Hi"),
                Arguments.of(1, "Hey"),
                Arguments.of(2, "3te s3n"));
    }

    public static Stream<Arguments> valueAndExpectedIndex() {
        return Stream.of(
                Arguments.of("bon soir", 0),
                Arguments.of("bon jour", 1),
                Arguments.of("ola!", 2));
    }

    @Test
    void ensureElementsArePrependedCorrectly() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.linkFirst(secondElement);
        list.linkFirst(firstElement);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    void ensureElementsAreAppendedCorrectly() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.linkLast(firstElement);
        list.linkLast(secondElement);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    void ensureElementsAreAddedCorrectlyWhenInstantiated() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @ParameterizedTest
    @MethodSource("valueAndExpectedIndex")
    void ensureElementIsAddedAtTheGivenIndex(String value, int expectedIndex) {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        list.link(expectedIndex, value);
        assertEquals(expectedIndex, list.indexOf(value));
        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
    }

    @Test
    void ensureExceptionIsThrownWhenGivenIndexIsOutOfBounds() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertThrows(IndexOutOfBoundsException.class, () -> list.link(25, "Hola"));
    }

    @Test
    void ensureIndexIsReturnedForAGivenValue() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>(
                firstElement,
                secondElement,
                thirdElement);
        assertEquals(1, list.indexOf(secondElement));
    }

    @Test
    void ensureNegativeOneIsReturnedForAGivenValueNotInList() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>(
                firstElement,
                secondElement,
                thirdElement);
        assertEquals(-1, list.indexOf("sup"));
    }

    @Test
    void ensureFirstLinkIsReturned() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertEquals(firstElement, list.getFirstLink());
    }

    @Test
    void ensureLastLinkIsReturned() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertEquals(thirdElement, list.getLastLink());
    }

    @ParameterizedTest
    @MethodSource("indexAndExpectedValue")
    void ensureLinkIsReturnedAtAGivenIndex(int index, String expectedValue) {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertEquals(expectedValue, list.getLink(index));
    }

    @Test
    void ensureExceptionIsThrownForOutOfBoundsIndex() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getLink(25));
    }

    @Test
    void ensureFirstElementIsRemoved() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertEquals(firstElement, list.unlinkFirst());
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    void ensureRemovingFromEmptyListThrowsException() {
        assertThrows(RuntimeException.class, () -> new DoublyLinkedList<String>().unlinkFirst());
        assertThrows(RuntimeException.class, () -> new DoublyLinkedList<String>().unlinkLast());
    }

    @Test
    void ensureLastElementIsRemoved() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>(
                firstElement,
                secondElement,
                thirdElement);
        assertEquals(thirdElement, list.unlinkLast());
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(secondElement, list.getLastLink());
    }
    @ParameterizedTest
    @MethodSource("indexAndExpectedValue")
    void ensureElementIsRemoved(int index, String expectedValue) {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>(
                firstElement,
                secondElement,
                thirdElement);
        assertEquals(expectedValue, list.unlink(index));
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    void ensureExceptionIsThrownWhenIndexIsInvalidWhileDeleting() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        assertThrows(IndexOutOfBoundsException.class, () -> list.unlink(25));
        assertThrows(IndexOutOfBoundsException.class, () -> list.unlink(-2));
    }

    @Test
    void ensureAllElementsAreCleared() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list =
                new DoublyLinkedList<>(firstElement, secondElement, thirdElement);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void ensureTheCorrectIndexIsReturned() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.link(firstElement);
        list.link(secondElement);
        list.link(thirdElement);
        assertEquals(1, list.indexOf(secondElement));
    }

    @ParameterizedTest
    @MethodSource("indexAndExpectedValue")
    void ensureTheCorrectLinkIsReturnedAtIndex(int index, String element) {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.link(firstElement);
        list.link(secondElement);
        list.link(thirdElement);
        assertEquals(element, list.getLink(index));
    }

    @Test
    void ensureGettingInvalidVinReturnsNull() {
        String firstElement = "Hi";
        String secondElement = "Hey";
        String thirdElement = "3te s3n";
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.link(firstElement);
        list.link(secondElement);
        list.link(thirdElement);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getLink(55));
    }

    @Test
    void ensureToStringReturnsExistingElementsIntoString() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.link(1);
        list.link(2);
        list.link(3);
        list.link(4);
        list.link(5);
        assertNotNull(list.toString());
        assertEquals(
                "{HEAD} --> <-- 1 --> <-- 2 --> <-- 3 --> <-- 4 --> <-- 5 --> {TAIL}", list.toString());
    }

    @Test
    void ensureToStringOnEmptyLinkedListReturnsEmptyString() {
        assertEquals("", new DoublyLinkedList<Integer>().toString());
    }
}
