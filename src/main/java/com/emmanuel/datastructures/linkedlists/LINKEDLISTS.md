# Linked Lists 🔗

## Definition:
> ***A linked list is a recursive data structure that is either empty or has a
reference to a node having a generic item and a reference to a linked list.
The linked list consist of a few parts which are the head, tail, node and pointer***

- ***Node***: A node of a linked list is an abstract entity or object
that contains the pointer to the next node and value of the node.
- ***Head***: A head is considered to be the starting point of a linked list.
- **Pointer**: A pointer is the reference of the next node the current node points to.
- **Tail**: A tail is considered to be the end of a linked list. This means the last node will point to null.

## Singly Linked List
> ***A singly linked list is a linked list that has only a reference to the next
node that refers to the linked list. Since singly linked list has only one pointer,
the space consumed is 2 times less the amount of doubly linked list
> however it cannot be traversed backwards***

### Complexity
- Access: O(n)
- Search: 0(n)
- Insert at head: O(1)
- Insert at tail: O(1)
- Delete at head: O(1)
- Delete at tail: O(n)
- Delete at middle: O(n)


## Doubly Linked List
> ***A doubly linked list is linked list that has two pointers
> which points to the previous node and the next node. 
> Because of the two pointers,
> the memory consumed are 2 times more than singly linked list.
But the advantage of it is the backwards traversal capability.***

### Complexity
- Access: O(n)
- Search: 0(n)
- Insert at head: O(1)
- Insert at tail: O(1)
- Insert at middle: O(n)
- Delete at head: O(1)
- Delete at tail: O(1)
- Delete at middle: O(n)



