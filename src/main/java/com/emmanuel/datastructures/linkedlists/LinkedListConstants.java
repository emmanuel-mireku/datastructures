package com.emmanuel.datastructures.linkedlists;

public final class LinkedListConstants {
    private LinkedListConstants() {}
    public static final String DELETION_INVALID_EMPTY_LIST =
            "Deletion operation cannot be performed. List is empty.";
    public static final String DELETION_INVALID_NO_INDEX =
            "Deletion operation cannot be performed. Index is out of bounds";

    public static final String INDEX_OUT_OF_BOUNDS =
            "Cannot get node because the current index is out of bounds.";

    public static final String CANNOT_ADD_OUT_OF_BOUNDS =
            "Cannot add link because the current index is out of bounds. Ensure link is within bounds.";


}
