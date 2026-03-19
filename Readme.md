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

| Method                                     | Custom (ns) | java LinkedList (ns) | Winner         | Margin |
|--------------------------------------------|-------------|----------------------|----------------|--------|
| add(E)                                     | 286355      | 326104               | **Custom**     | 1.14×  |
| add(int index, E)                          | 93032       | 91354                | **LinkedList** | 1.02×  |
| addAll(Collection<? extends E>)            | 207510      | 167416               | **LinkedList** | 1.24×  |
| addAll(int index, Collection<? extends E>) | 312307      | 306161               | **LinkedList** | 1.02×  |
| addFirst(E)                                | 57          | 58                   | **Custom**     | ~1.02× |
| addLast(E)                                 | 37          | 82                   | **Custom**     | 2.22×  |
| clear()                                    | 129491      | 126518               | **LinkedList** | 1.02×  |
| clone()                                    | 215462      | 253823               | **Custom**     | 1.18×  |
| contains(Object)                           | 140364      | 204337               | **Custom**     | 1.46×  |
| containsAll(Collection<?>)                 | 102046322   | 97712046             | **LinkedList** | 1.04×  |
| element()                                  | 37          | 35                   | **LinkedList** | ~1.06× |
| equals(Object)                             | 224489      | 218164               | **LinkedList** | 1.03×  |
| get(int)                                   | 93614       | 88597                | **LinkedList** | 1.06×  |
| getFirst()                                 | 40          | 39                   | **LinkedList** | ~1.03× |
| getLast()                                  | 39          | 35                   | **LinkedList** | 1.11×  |
| hashCode()                                 | 207132      | 135869               | **LinkedList** | 1.52×  |
| indexOf(Object)                            | 149178      | 199346               | **Custom**     | 1.34×  |
| isEmpty()                                  | 21          | 31                   | **Custom**     | 1.48×  |
| lastIndexOf(Object)                        | 53          | 41                   | **LinkedList** | 1.29×  |
| offer(E)                                   | 55          | 105                  | **Custom**     | 1.91×  |
| offerFirst(E)                              | 115         | 105                  | **LinkedList** | 1.10×  |
| offerLast(E)                               | 51          | 56                   | **Custom**     | 1.10×  |
| peek()                                     | 38          | 37                   | **LinkedList** | ~1.03× |
| peekFirst()                                | 37          | 16                   | **LinkedList** | 2.31×  |
| peekLast()                                 | 16          | 28                   | **Custom**     | 1.75×  |
| poll()                                     | 28          | 27                   | **LinkedList** | ~1.04× |
| pollFirst()                                | 27          | 41                   | **Custom**     | 1.52×  |
| pollLast()                                 | 41          | 69                   | **Custom**     | 1.68×  |
| pop()                                      | 69          | 29                   | **LinkedList** | 2.38×  |
| push(E)                                    | 29          | 37                   | **Custom**     | 1.28×  |
| remove()                                   | 37          | 40                   | **Custom**     | 1.08×  |
| remove(int)                                | 92971       | 92644                | **LinkedList** | ~1.00× |
| remove(Object)                             | 160399      | 197024               | **Custom**     | 1.23×  |
| removeAll(Collection<?>)                   | 567338      | 724177529            | **Custom**     | ~1276× |
| removeFirst()                              | 27          | 40                   | **Custom**     | 1.48×  |
| removeFirstOccurrence(Object)              | 166809      | 195284               | **Custom**     | 1.17×  |
| removeLast()                               | 32          | 61                   | **Custom**     | 1.91×  |
| removeLastOccurrence(Object)               | 135         | 61                   | **LinkedList** | 2.21×  |
| retainAll(Collection<?>)                   | 665167      | 733797679            | **Custom**     | ~1103× |
| set(int, E)                                | 102767      | 90557                | **LinkedList** | 1.13×  |
| size()                                     | 75          | 28                   | **LinkedList** | 2.68×  |
| subList(int, int)                          | 148036      | 129491               | **LinkedList** | 1.14×  |
| toArray()                                  | 124177      | 121581               | **LinkedList** | 1.02×  |
| toArray(T[])                               | 178334      | 131129               | **LinkedList** | 1.36×  |
| toString()                                 | 1892913     | 1384150              | **LinkedList** | 1.37×  |


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
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/hashCode().png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/indexOf(Object).png)
![Combined Performance Charts](PerformanceTesting/Graphs/DoublyVsLinkedList/isEmpty().png)
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



























