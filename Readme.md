# LinkedList
Custom implementation of a doubly LinkedList.
All methods implemented are of the [Java Linked List](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) class including the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html), [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html), [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) and [Cloneable](https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html) interfaces.

Implementation of a Singly Linked List can be found [here](https://github.com/bk10aao/CustomLinkedList).

![Null-Hostile](https://img.shields.io/badge/null-hostile-red)
![JDK-Matched](https://img.shields.io/badge/performance-JDK%20matched-blue)

### Time complexity

| Method                                       | Custom                     | Java LinkedList            | Verdict |
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

| Method                                       | Custom                 | Java LinkedList        | Verdict |
|----------------------------------------------|------------------------|------------------------|---------|
| `add(E)`                                     | O(1)                   | O(1)                   | Tie     |
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

# Performance

Below performance is a comparison made at 100,000 operations per method.

Note: all data is an average of 100 runs.

| Method                                     | Custom (ns) | java LinkedList (ns) | Winner     | Margin |
|--------------------------------------------|-------------|----------------------|------------|--------|
| add(E)                                     | 386084      | 326104               | LinkedList | 1.18×  |
| add(int index, E)                          | 92195       | 91354                | LinkedList | 1.01×  |
| addAll(Collection<? extends E>)            | 224323      | 167416               | LinkedList | 1.34×  |
| addAll(int index, Collection<? extends E>) | 307855      | 306161               | LinkedList | 1.01×  |
| addFirst(E)                                | 58          | 58                   | Tie        | 1.00×  |
| addLast(E)                                 | 47          | 82                   | Custom     | 1.74×  |
| clear()                                    | 26          | 126518               | Custom     | 4866×  |
| clone()                                    | 214191      | 253823               | Custom     | 1.19×  |
| contains(Object)                           | 139915      | 204337               | Custom     | 1.46×  |
| containsAll(Collection<? extends E>)       | 101664761   | 97712046             | LinkedList | 1.04×  |
| element()                                  | 41          | 35                   | LinkedList | ~1.17× |
| equals(Object)                             | 236044      | 218164               | LinkedList | 1.08×  |
| get(int)                                   | 92107       | 88597                | LinkedList | 1.04×  |
| getFirst()                                 | 21          | 35                   | Custom     | 1.67×  |
| getLast()                                  | 24          | 35                   | Custom     | 1.46×  |
| hashCode()                                 | 210055      | 135869               | LinkedList | 1.55×  |
| indexOf(Object)                            | 210055      | 135869               | LinkedList | 1.55×  |
| isEmpty()                                  | 24          | 40                   | Custom     | 1.67×  |
| lastIndexOf(Object)                        | 149187      | 199346               | Custom     | 1.34×  |
| offer(E)                                   | 57          | 105                  | Custom     | 1.84×  |
| offerFirst(E)                              | 124         | 105                  | LinkedList | ~1.18× |
| offerLast(E)                               | 54          | 105                  | Custom     | 1.94×  |
| peek()                                     | 45          | 41                   | LinkedList | ~1.10× |
| peekFirst()                                | 41          | 31                   | LinkedList | ~1.32× |
| peekLast()                                 | 23          | 26                   | Custom     | 1.13×  |
| poll()                                     | 109         | 154                  | Custom     | 1.41×  |
| pollFirst()                                | 24          | 31                   | Custom     | 1.29×  |
| pollLast()                                 | 42          | 68                   | Custom     | 1.62×  |
| pop()                                      | 22          | 84                   | Custom     | 3.82×  |
| push(E)                                    | 121         | 84                   | LinkedList | ~1.44× |
| remove()                                   | 33          | 40                   | Custom     | 1.21×  |
| remove(int)                                | 91760       | 92644                | Custom     | 1.01×  |
| remove(Object)                             | 158802      | 197024               | Custom     | 1.24×  |
| removeAll(Collection<? extends E>)         | 480438      | 167416               | LinkedList | 2.87×  |
| removeFirst()                              | 30          | 28                   | LinkedList | ~1.07× |
| removeFirstOccurrence(Object)              | 158816      | 195284               | Custom     | 1.23×  |
| removeLast()                               | 90          | 61                   | LinkedList | ~1.48× |
| removeLastOccurrence(Object)               | 78          | 68                   | LinkedList | ~1.15× |
| retainAll(Collection<? extends E>)         | 495608      | 733797679            | Custom     | 1480×  |
| set(int, E)                                | 94334       | 90557                | LinkedList | 1.04×  |
| size()                                     | 23          | 40                   | Custom     | 1.74×  |
| subList(int, int)                          | 495608      | 724177529            | Custom     | 1462×  |
| toArray()                                  | 127465      | 197024               | Custom     | 1.55×  |
| toArray(T[])                               | 131095      | 197024               | Custom     | 1.50×  |
| toString()                                 | 1865972     | 724177529            | Custom     | 388×   |

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
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toArray(T[]).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/toString().png)



























