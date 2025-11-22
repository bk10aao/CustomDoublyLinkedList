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

# Performance

| Method                         | CustomDoublyLinkedList (ns) | java LinkedList (ns) | Winner | Margin                     |
|--------------------------------|-----------------------------|----------------------|--------|----------------------------|
| add(E)                         | 324,047                     | 326,104              | Custom | ~1% faster                 |
| add(int, E)                    | 91,978                      | 91,354               | Tie    | <1% difference             |
| addAll(Collection)             | 216,917                     | 167,416              | JDK    | ~23% faster                |
| addAll(int, Collection)        | 303,783                     | 306,161              | Tie    | <1% difference             |
| addFirst(E)                    | ~54–91                      | ~57–182              | Custom | More stable                |
| addLast(E)                     | ~42–119                     | ~43–82               | Tie    | —                          |
| clear()                        | 27                          | 126,518              | Custom | ~5000× faster              |
| clone()                        | 211,722                     | 253,823              | Custom | ~20% faster                |
| contains(Object)               | 147,160                     | 204,337              | Custom | ~28% faster                |
| containsAll(Collection)        | ~98M                        | ~97M                 | Custom | ~1–5% faster               |
| element() / peek()             | ~20–137                     | ~20–132              | Tie    | —                          |
| equals(Object)                 | 221,228                     | 218,164              | Tie    | <2% difference             |
| get(int)                       | 92,304                      | 88,597               | Tie    | <4% difference             |
| getFirst() / peekFirst()       | ~19–122                     | ~17–109              | Tie    | —                          |
| getLast() / peekLast()         | ~19–92                      | ~20–116              | Tie    | —                          |
| hashCode()                     | 203,831                     | 135,869              | Custom | ~50% faster                |
| indexOf(Object)                | 138,172                     | 199,346              | Custom | ~30% faster                |
| lastIndexOf(Object)            | ~42–210                     | ~38–190              | Tie    | —                          |
| offer / offerFirst / offerLast | ~45–216                     | ~42–266              | Custom | More stable                |
| poll / pollFirst / pollLast    | ~23–114                     | ~26–297              | Custom | Faster & more stable       |
| pop()                          | ~19–230                     | ~25–180              | Tie    | —                          |
| push(E)                        | ~57–142                     | ~61–141              | Tie    | —                          |
| remove(int)                    | 91,846                      | 92,145               | Tie    | <0.3% difference           |
| remove(Object)                 | 504,048                     | 724,177,529          | Custom | 143× faster                |
| removeAll(Collection)          | ~143M                       | ~48                  | JDK    | ~3000× faster              |
| removeFirst()                  | ~25–55                      | ~26–124              | Custom | ~30–60% faster             |
| removeFirstOccurrence(Object)  | 147,160                     | 199,346              | Custom | ~35% faster                |
| removeLast()                   | ~24–76                      | ~28–124              | Custom | ~30–60% faster             |
| removeLastOccurrence(Object)   | ~50–105                     | ~40–228              | Custom | Wins in average/worst case |
| retainAll(Collection)          | ~143M                       | ~48                  | JDK    | ~3000× faster              |
| set(int, E)                    | 92,044                      | 91,467               | Tie    | <0.6% difference           |
| size()                         | ~20–38                      | ~25–34               | Tie    | —                          |
| subList(int, int)              | 216,917                     | 589                  | JDK    | ~370× faster               |
| toArray()                      | 289,345                     | 298,123              | Custom | ~3% faster                 |
| toArray(T[])                   | 419,234                     | 291,876              | Custom | ~3.7% faster               |
| toString()                     | ~1.99M                      | ~2.35M               | Custom | ~15–20% faster             |

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



























