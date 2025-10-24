# LinkedList
Custom implementation of a doubly LinkedList. Implementation of a Singly Linked List can be found [here](https://github.com/bk10aao/CustomLinkedList).

# Methods
1. `CustomDoublyLinkedList()` - constructor.
2. `CustomDoublyLinkedList(Collection<E> items)` - constructor with Collection of items to be added to list, throws NullPointerException on null collection.
3. `boolean add(E item)` - add item to list, returns true if successful, else false.
4. `void add(int index, E item)` - add item to list at given index - throws IndexOutOfBoundsException.
5. `boolean addAll(Collection<E> collection)` - adds collection of items to list, return true if list has changed, else false.
6. `boolean addAll(int index, Collection<E> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
7. `void addFirst(E item)` - adds item to start of list.
8. `void addLast(E item)` - adds item to end of list.
9. `CustomDoublyLinkedList<E> clone()` - returns a shallow copy of the list.
10. `boolean contains(E item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
11. `E element()` - returns item at start of list.
12. `boolean equals(Object o)` - compares if two lists are equals, returns true if equal else false.
13. `E get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
14. `int ashCode()` - returns hashcode of list object.
15. `int indexOf(E item)` - returns the index of item in list if present, else -1.
16. `int lastIndexOf(E item)` - returns last index of item in list, else -1.
17. `boolean offer(E item)` - adds item to end of list. returns true if successful, else false.
18. `boolean offerFirst(E item)` - adds item to start of list. returns true if successful, else false.
19. `boolean offerLast(E item)` - adds item to end of list. returns true if successful, else false.
20. `E peek()` - returns but does not remove item at start of list, if empty return null.
21. `E peekFirst()` - returns but does not remove item from start of list if present, else false.
22. `E peekLast()` - returns but does not remove item at end of list if present, else null.
23. `E poll()` - remove and return item from start of list.
24. `E pollFirst()` - remove and return item from start of list, else null.
25. `E pollLast()` - remove and return item at end of list, else null.
26. `void push()` - adds item to start of list.
27. `E pop()` - remove and return item from start of list.
28. `E remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
29. `E remove(E item)` - remove and return item from list if present, else return null.
30. `E removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
31. `boolean removeFirstOccurrence(E item)` - remove first occurrence of item in list, returns true if removed, else false.
32. `E removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
33. `boolean removeLastOccurrence(E item)` - removes last occurrence of item in list, returns true if list has changed, else false.
34. `E set(int index, E item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
35. `int size()` - return size of list.
36. `E[] toArray()` - return list as array.
37. `String toString()` - return String representation of list.

# Complexities

O time and space complexities and graphs are compared to standard Java Linked List and [Custom Singly Linked List](https://github.com/bk10aao/CustomLinkedList)

### Time complexity Comparisons CustomLinkedList (singly) vs CustomDoublyLinkedList vs LinkedList

| Method           | CustomLinkedList | CustomDoublyLinkedList | LinkedList (Java) |                Winner                |
|------------------|:----------------:|:----------------------:|:-----------------:|:------------------------------------:|
| `add(E)`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `add(int, E)`    |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `addFirst(E)`    |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `addLast(E)`     |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `get(int)`       |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `remove()`  `    |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `removeFirst()`  |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `removeLast()`   |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `remove(int)`    |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `contains(E)`    |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `indexOf(E)`     |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `lastIndexOf(E)` |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `clear()`        |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `size()`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `clone()`        |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `toArray()`      |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `toString()`     |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `offer(E)`       |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `peek()`         |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `element()`      |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `poll()`         |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `push(E)`        |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `pop()`          |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |

### Space complexity CustomLinkedList (singly) vs CustomDoublyLinkedList vs LinkedList

| Method           | CustomLinkedList | CustomDoublyLinkedList | LinkedList (Java) |                Winner                |
|------------------|:----------------:|:----------------------:|:-----------------:|:------------------------------------:|
| `add(E)`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `add(int, E)`    |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `addFirst(E)`    |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `addLast(E)`     |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `get(int)`       |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `remove()`       |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `remove()`       |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `removeLast()`   |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `remove(int)`    |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `contains(E)`    |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `indexOf(E)`     |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `lastIndexOf(E)` |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `clear()`        |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `size()`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `clone()`        |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `toArray()`      |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `toString()`     |       O(n)       |          O(n)          |       O(n)        |                 Tie                  |
| `offer(E)`       |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `peek()`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `element()`      |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `poll()`         |       O(1)       |          O(1)          |       O(1)        |                 Tie                  |
| `push(E)`        |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |
| `pop()`          |       O(n)       |          O(1)          |       O(1)        | Doubly Linked List, Java Linked List |

notes:
- *n* = Number of elements in the list.
- *m* = Number of elements in the input

# Performance Charts

### Custom Singly Linked List vs Custom Doubly Linked List vs Java Linked List

![Combined Performance Charts](PerformanceTesting/Graphs/Constructor().png)
![Combined Performance Charts](PerformanceTesting/Graphs/Constructor(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/add(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/add(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/addAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/addAll(int,%20Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/addFirst(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/addLast(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/clone().png)
![Combined Performance Charts](PerformanceTesting/Graphs/contains(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/element().png)
![Combined Performance Charts](PerformanceTesting/Graphs/equals(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/get(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/hashCode().png)
![Combined Performance Charts](PerformanceTesting/Graphs/indexOf(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/lastIndexOf(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/offer(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/offerFirst(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/offerLast(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/peek().png)
![Combined Performance Charts](PerformanceTesting/Graphs/peekFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/peekLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/poll().png)
![Combined Performance Charts](PerformanceTesting/Graphs/pollFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/pollLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/pop().png)
![Combined Performance Charts](PerformanceTesting/Graphs/push(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/remove(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/remove(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/removeFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/removeFirstOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/removeLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/removeLastOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/set(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/size().png)
![Combined Performance Charts](PerformanceTesting/Graphs/toArray().png)
![Combined Performance Charts](PerformanceTesting/Graphs/toString().png)

### Custom Doubly Linked List vs Java Linked List

![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/add(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/add(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addAll(int,%20Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addFirst(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addLast(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/clone().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/contains(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/element().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/equals(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/get(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/hashCode().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/indexOf(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/lastIndexOf(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offer(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offerFirst(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offerLast(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peek().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peekFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peekLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/poll().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pollFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pollLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pop().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/push(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/remove(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/remove(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeFirstOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeLastOccurence(T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/set(int,%20T).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/size().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toArray().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toString().png)
































