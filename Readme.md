# LinkedList
Custom implementation of a doubly LinkedList.
All methods implemented are of the [Java Linked List](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html), standard [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) and [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html) interfaces.

Implementation of a Singly Linked List can be found [here](https://github.com/bk10aao/CustomLinkedList).

![Null-Hostile](https://img.shields.io/badge/null-hostile-red)
![O(1) head/tail](https://img.shields.io/badge/O(1)-head%2Ftail-brightgreen)
![JDK-Matched](https://img.shields.io/badge/performance-JDK%20matched-blue)

### Time complexity

| Method                                       | CustomDoublyLinkedList     | Java LinkedList            | Verdict |
|----------------------------------------------|----------------------------|----------------------------|---------|
| `add(E)`                                     | O(1)                       | O(1)                       | Tie     |
| `addLast(E)`                                 | O(1)                       | O(1)                       | Tie     |
| `add(int index, E)`                          | O(min(index, n−index))     | O(min(index, n−index))     | Tie     |
| `addAll(Collection<? extends E>)`            | O(m)                       | O(m)                       | Tie     |
| `addAll(int index, Collection<? extends E>)` | O(m + min(index, n−index)) | O(m + min(index, n−index)) | Tie     |
| `addFirst(E)`                                | O(1)                       | O(1)                       | Tie     |
| `addLast(E)`                                 | O(1)                       | O(1)                       | Tie     |
| `clear()`                                    | O(1)                       | O(1)                       | Tie     |
| `clone()`                                    | O(n)                       | O(n)                       | Tie     |
| `contains(Object)`                           | O(n)                       | O(n)                       | Tie     |
| `element()`                                  | O(1)                       | O(1)                       | Tie     |
| `get(int index)`                             | O(min(index, n−index))     | O(min(index, n−index))     | Tie     |
| `indexOf(Object)`                            | O(n)                       | O(n)                       | Tie     |
| `isEmpty()`                                  | O(1)                       | O(1)                       | Tie     |
| `iterator()`                                 | O(n)                       | O(n)                       | Tie     |
| `lastIndexOf(Object)`                        | O(n)                       | O(n)                       | Tie     |
| `listIterator()`                             | O(n)                       | O(n)                       | Tie     |
| `offer(E)`                                   | O(1)                       | O(1)                       | Tie     |
| `offerFirst(E)`                              | O(1)                       | O(1)                       | Tie     |
| `offerLast(E)`                               | O(1)                       | O(1)                       | Tie     |
| `peek()`                                     | O(1)                       | O(1)                       | Tie     |
| `peekFirst()`                                | O(1)                       | O(1)                       | Tie     |
| `peekLast()`                                 | O(1)                       | O(1)                       | Tie     |
| `poll()`                                     | O(1)                       | O(1)                       | Tie     |
| `pollFirst()`                                | O(1)                       | O(1)                       | Tie     |
| `pollLast()`                                 | O(1)                       | O(1)                       | Tie     |
| `pop()`                                      | O(1)                       | O(1)                       | Tie     |
| `push(E)`                                    | O(1)                       | O(1)                       | Tie     |
| `remove(int index)`                          | O(min(index, n−index))     | O(min(index, n−index))     | Tie     |
| `remove(Object o)`                           | O(n)                       | O(n)                       | Tie     |
| `removeFirst()`                              | O(1)                       | O(1)                       | Tie     |
| `removeFirstOccurrence(Object)`              | O(n)                       | O(n)                       | Tie     |
| `removeLast()`                               | O(1)                       | O(1)                       | Tie     |
| `removeLastOccurrence(Object)`               | O(n)                       | O(n)                       | Tie     |
| `set(int index, E)`                          | O(min(index, n−index))     | O(min(index, n−index))     | Tie     |
| `size()`                                     | O(1)                       | O(1)                       | Tie     |
| `subList(int fromIndex, int toIndex)`        | O(n)                       | O(n)                       | Tie     |
| `toArray()`                                  | O(n)                       | O(n)                       | Tie     |
| `toString()`                                 | O(n)                       | O(n)                       | Tie     |

### Space complexity

| Method                                       | CustomDoublyLinkedList | Java LinkedList        | Verdict |
|----------------------------------------------|------------------------|------------------------|---------|
| `add(E)`                                     | O(1)                   | O(1)                   | Tie     |
| `addLast(E)`                                 | O(1)                   | O(1)                   | Tie     |
| `add(int index, E)`                          | O(1)                   | O(1)                   | Tie     |
| `addAll(Collection<? extends E>)`            | O(m)                   | O(m)                   | Tie     |
| `addAll(int index, Collection<? extends E>)` | O(m)                   | O(m)                   | Tie     |
| `addFirst(E)`                                | O(1)                   | O(1)                   | Tie     |
| `addLast(E)`                                 | O(1)                   | O(1)                   | Tie     |
| `clear()`                                    | O(1)                   | O(1)                   | Tie     |
| `clone()`                                    | O(n)                   | O(n)                   | Tie     |
| `contains(Object)`                           | O(1)                   | O(1)                   | Tie     |
| `element()`                                  | O(1)                   | O(1)                   | Tie     |
| `get(int index)`                             | O(1)                   | O(1)                   | Tie     |
| `indexOf(Object)`                            | O(1)                   | O(1)                   | Tie     |
| `isEmpty()`                                  | O(1)                   | O(1)                   | Tie     |
| `iterator()`                                 | O(1)                   | O(1)                   | Tie     |
| `lastIndexOf(Object)`                        | O(1)                   | O(1)                   | Tie     |
| `listIterator()`                             | O(1)                   | O(1)                   | Tie     |
| `listIterator(int index)`                    | O(1)                   | O(1)                   | Tie     |
| `offer(E)`                                   | O(1)                   | O(1)                   | Tie     |
| `offer(E)`                                   | O(1)                   | O(1)                   | Tie     |
| `offerFirst(E)`                              | O(1)                   | O(1)                   | Tie     |
| `offerLast(E)`                               | O(1)                   | O(1)                   | Tie     |
| `peek()`                                     | O(1)                   | O(1)                   | Tie     |
| `peekFirst()`                                | O(1)                   | O(1)                   | Tie     |
| `peekFirst()`                                | O(1)                   | O(1)                   | Tie     |
| `peekLast()`                                 | O(1)                   | O(1)                   | Tie     |
| `poll()`                                     | O(1)                   | O(1)                   | Tie     |
| `pollFirst()`                                | O(1)                   | O(1)                   | Tie     |
| `pollLast()`                                 | O(1)                   | O(1)                   | Tie     |
| `pop()`                                      | O(1)                   | O(1)                   | Tie     |
| `push(E)`                                    | O(1)                   | O(1)                   | Tie     |
| `remove(int index)`                          | O(1)                   | O(1)                   | Tie     |
| `remove(Object o)`                           | O(1)                   | O(1)                   | Tie     |
| `removeFirst()`                              | O(1)                   | O(1)                   | Tie     |
| `removeFirstOccurrence(Object)`              | O(1)                   | O(1)                   | Tie     |
| `removeLast()`                               | O(1)                   | O(1)                   | Tie     |
| `removeLastOccurrence(Object)`               | O(1)                   | O(1)                   | Tie     |
| `set(int index, E)`                          | O(1)                   | O(1)                   | Tie     |
| `size()`                                     | O(1)                   | O(1)                   | Tie     |
| `subList(int fromIndex, int toIndex)`        | O(k) where k = to−from | O(k) where k = to−from | Tie     |
| `toArray()`                                  | O(n)                   | O(n)                   | Tie     |
| `toArray(T[] a)`                             | O(n)                   | O(n)                   | Tie     |
| `toString()`                                 | O(n) temporary         | O(n) temporary         | Tie     |

**n** = current number of elements in the list  
**m** = number of elements being added

# Performance Charts

### Custom Doubly Linked List vs Java Linked List
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/add(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/add(int,%20E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addAll(int,%20Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addFirst(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/addLast(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/clear().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/clone().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/contains(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/containsAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/element().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/equals(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/get(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/getFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/getLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/hashcode().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/indexOf(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/lastIndexOf(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offer(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offerFirst(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/offerLast(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peek().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peekFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/peekLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/poll().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pollFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pollLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/pop().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/push(E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/remove(int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/remove(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeFirst().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeFirstOccurrence(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeLast().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/removeLastOccurrence(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/retainAll(Collection).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/set(int,%20E).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/size().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/subList(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toArray().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toArray(T[]).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toString().png)



























