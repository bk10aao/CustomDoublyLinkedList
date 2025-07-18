# LinkedList
Custom implementation of a doubly LinkedList

# Methods
1. `CustomDoublyLinkedList()` - constructor.
2. `CustomDoublyLinkedList(Collection<T> items)` - constructor with Collection of items to be added to list, throws NullPointerException on null collection.
3. `boolean add(T item)` - add item to list, returns true if successful, else false.
4. `void add(int index, T item)` - add item to list at given index - throws IndexOutOfBoundsException.
5. `boolean addAll(Collection<T> collection)` - adds collection of items to list, return true if list has changed, else false.
6. `boolean addAll(int index, Collection<T> collection)` adds all items in collection at given index, throws NullPointerException on null collection, throw IndexOutOfBoundsException on index smaller than 0 or larger than list size.
7. `void addFirst(T item)` - adds item to start of list.
8. `void addLast(T item)` - adds item to end of list.
9. `CustomDoublyLinkedList<T> clone()` - returns a shallow copy of the list.
10. `boolean contains(T item)` - checks if list contains item, returns true if present, else false. Throws NullPointerException on null item.
11. `T element()` - returns item at start of list.
12. `boolean equals(Object o)` - compares if two lists are equals, returns true if equal else false.
13. `T get(int index)` - get item at given index from list, throws IndexOutOfBoundsException on index less than zero or larger than list size.
14. `int ashCode()` - returns hashcode of list object.
15. `int indexOf(T item)` - returns the index of item in list if present, else -1.
16. `int lastIndexOf(T item)` - returns last index of item in list, else -1.
17. `boolean offer(T item)` - adds item to end of list. returns true if successful, else false.
18. `boolean offerFirst(T item)` - adds item to start of list. returns true if successful, else false.
19. `boolean offerLast(T item)` - adds item to end of list. returns true if successful, else false.
20. `T peek()` - returns but does not remove item at start of list, if empty return null.
21. `T peekFirst()` - returns but does not remove item from start of list if present, else false.
22. `T peekLast()` - returns but does not remove item at end of list if present, else null.
23. `T poll()` - remove and return item from start of list.
24. `T pollFirst()` - remove and return item from start of list, else null.
25. `T pollLast()` - remove and return item at end of list, else null.
26. `void push()` - adds item to start of list.
27. `T pop()` - remove and return item from start of list.
28. `T remove()` - remove and return item from start of list, throws NoSuchElementException on empty list.
29. `T remove(T item)` - remove and return item from list if present, else return null.
30. `T removeFirst()` - remove and return item from start of list, throw NoSuchElementException on empty list.
31. `boolean removeFirstOccurrence(T item)` - remove first occurrence of item in list, returns true if removed, else false.
32. `T removeLast()` - remove last item from list, throws NoSuchElementException on empty list.
33. `boolean removeLastOccurrence(T item)` - removes last occurrence of item in list, returns true if list has changed, else false.
34. `T set(int index, T item)` - sets item at index to new value, returns previous value at index, throws IndexOutOfBoundsException on index smaller than 0 or larger than list size.
35. `int size()` - return size of list.
36. `T[] toArray()` - return list as array.
37. `String toString()` - return String representation of list.


## Time complexity Comparisons CustomLinkedList (singly) vs CustomDoublyLinkedList vs LinkedList

| Operation                    | CustomLinkedList | CustomDoublyLinkedList | LinkedList (Java) | **Winner**         |
|------------------------------|------------------|------------------------|-------------------|--------------------|
| `add(T)` (append)            | **O(1)**         | **O(1)**               | **O(1)**          | Tie                |
| `add(int, T)`                | O(n)             | O(n)                   | O(n)              | Tie                |
| `addFirst(T)`                | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `addLast(T)`                 | **O(1)**         | **O(1)**               | **O(1)**          | Tie                |
| `get(int)`                   | O(n)             | O(n)                   | O(n)              | Tie                |
| `remove()` / `removeFirst()` | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `removeLast()`               | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `remove(int)`                | O(n)             | O(n)                   | O(n)              | Tie                |
| `contains(T)`                | O(n)             | O(n)                   | O(n)              | Tie                |
| `indexOf(T)`                 | O(n)             | O(n)                   | O(n)              | Tie                |
| `lastIndexOf(T)`             | O(n)             | O(n)                   | O(n)              | Tie                |
| `clear()`                    | **O(1)**         | **O(1)**               | **O(1)**          | Tie                |
| `size()`                     | **O(1)**         | **O(1)**               | **O(1)**          | Tie                |
| `clone()`                    | O(n)             | O(n)                   | O(n)              | Tie                |
| `toArray()`                  | O(n)             | O(n)                   | O(n)              | Tie                |
| `toString()`                 | O(n)             | O(n)                   | O(n)              | Tie                |
| `offer(T)`                   | **O(1)**         | **O(1)**               | **O(1)**          | Tie                |
| `peek()` / `element()`       | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `poll()`                     | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `push(T)`                    | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |
| `pop()`                      | O(n)             | **O(1)**               | **O(1)**          | CustomDoubly, Java |

## Space complexity CustomLinkedList (singly) vs CustomDoublyLinkedList vs LinkedList

| Operation / Method              | CustomLinkedList              | CustomDoublyLinkedList            | LinkedList (Java)                 | **Winner**             |
|---------------------------------|-------------------------------|-----------------------------------|-----------------------------------|------------------------|
| `add(T)` / `addLast(T)`         | O(1) extra (new node)         | O(1) extra (new node with `prev`) | O(1) extra (plus object overhead) | **CustomLinkedList**   |
| `addFirst(T)`                   | O(n) (node shift simulated)   | O(1)                              | O(1)                              | **CustomDoubly**, Java |
| `add(int, T)`                   | O(1) for node, O(n) traversal | Same                              | Same                              | Tie                    |
| `get(int)`                      | O(1) space                    | O(1)                              | O(1)                              | Tie                    |
| `remove()` / `removeFirst()`    | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `removeLast()`                  | O(n) (traverse to end)        | O(1)                              | O(1)                              | **CustomDoubly**, Java |
| `remove(int)`                   | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `contains(T)`                   | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `indexOf(T)` / `lastIndexOf(T)` | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `clear()`                       | O(1) (drop reference)         | O(1)                              | O(1)                              | Tie                    |
| `size()`                        | O(1) (counter)                | O(1)                              | O(1)                              | Tie                    |
| `clone()`                       | O(n) (duplicate nodes)        | O(n)                              | O(n)                              | **CustomLinkedList**   |
| `toArray()`                     | O(n)                          | O(n)                              | O(n)                              | Tie                    |
| `toString()`                    | O(n)                          | O(n)                              | O(n)                              | Tie                    |
| `offer(T)`                      | Same as `addLast(T)`          | Same                              | Same                              | **CustomLinkedList**   |
| `peek()` / `element()`          | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `poll()`                        | O(1)                          | O(1)                              | O(1)                              | Tie                    |
| `push(T)`                       | O(n) (simulate stack head)    | O(1)                              | O(1)                              | **CustomDoubly**, Java |
| `pop()`                         | O(n)                          | O(1)                              | O(1)                              | **CustomDoubly**, Java |
