# LinkedList
Custom implementation of a doubly LinkedList.
All methods implemented are of the [Java Linked List](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html), standard [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) and [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html) interfaces.

Implementation of a Singly Linked List can be found [here](https://github.com/bk10aao/CustomLinkedList).

![Null-Hostile](https://img.shields.io/badge/null-hostile-red)
![O(1) head/tail](https://img.shields.io/badge/O(1)-head%2Ftail-brightgreen)
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

Below performance is a comparison made at 100,000 operations per method.

Note: all data is an average of 100 runs.

| Method                        | Custom (ns) | java.util.LinkedList (ns) | Winner     | Margin |
|-------------------------------|-------------|---------------------------|------------|--------|
| add(E)                        | 472881      | 492488                    | Custom     | 1.04×  |
| addAll(Collection)            | 239750      | 435524                    | Custom     | 1.82×  |
| addAll(int, Collection)       | 360129      | 530642                    | Custom     | 1.47×  |
| addFirst(E)                   | 61          | 93                        | Custom     | 1.52×  |
| addLast(E)                    | 55          | 69                        | Custom     | 1.25×  |
| getFirst()                    | 20          | ~35                       | Custom     | ~1.75× |
| getLast()                     | 27          | ~37                       | Custom     | ~1.37× |
| clone()                       | 205833      | 629292                    | Custom     | 3.06×  |
| contains(Object)              | 140467      | 246915                    | Custom     | 1.76×  |
| containsAll(Collection)       | 98279244    | 99370542                  | Custom     | 1.01×  |
| element()                     | 32          | 36                        | Custom     | 1.13×  |
| equals(Object)                | 220877      | 400747                    | Custom     | 1.81×  |
| get(int)                      | 90502       | 172413                    | Custom     | 1.91×  |
| hashCode()                    | 208345      | 367937                    | Custom     | 1.77×  |
| indexOf(Object)               | 208345      | 240764                    | Custom     | 1.16×  |
| isEmpty()                     | 46          | ~30                       | LinkedList | ~0.65× |
| lastIndexOf(Object)           | 132923      | 257643                    | Custom     | 1.94×  |
| offer(E)                      | 51          | 83                        | Custom     | 1.63×  |
| offerFirst(E)                 | 120         | 100                       | LinkedList | ~1.20× |
| offerLast(E)                  | 54          | 72                        | Custom     | 1.33×  |
| peek()                        | 45          | 49                        | Custom     | 1.09×  |
| peekFirst()                   | 41          | 38                        | LinkedList | ~1.07× |
| peekLast()                    | 23          | 37                        | Custom     | 1.61×  |
| poll()                        | 109         | 37                        | LinkedList | ~2.95× |
| pollFirst()                   | 24          | 39                        | Custom     | 1.63×  |
| pollLast()                    | 42          | 37                        | LinkedList | ~1.14× |
| push(E)                       | 121         | 102                       | LinkedList | ~1.19× |
| pop()                         | 22          | 59                        | Custom     | 2.68×  |
| remove()                      | 33          | 37                        | Custom     | 1.12×  |
| remove(int)                   | 91532       | 159068                    | Custom     | 1.74×  |
| remove(Object)                | 198049      | 314892                    | Custom     | 1.59×  |
| removeAll(Collection)         | 537216      | **156130**                | LinkedList | 3.44×  |
| removeFirst()                 | 29          | 37                        | Custom     | 1.28×  |
| removeFirstOccurrence(Object) | 154447      | 314892                    | Custom     | 2.04×  |
| removeLast()                  | 44          | 39                        | LinkedList | ~1.13× |
| removeLastOccurrence(Object)  | 78          | 159068                    | Custom     | ~2.04× |
| retainAll(Collection)         | **254623**  | 166496                    | Custom     | 1.53×  |
| set(int, E)                   | 92919       | 158453                    | Custom     | 1.71×  |
| size()                        | 30          | 21                        | LinkedList | ~1.43× |
| subList(int, int)             | **92786**   | 1627607                   | Custom     | 17.5×  |
| toArray()                     | 124479      | 210621                    | Custom     | 1.69×  |
| toArray(T[])                  | 131324      | 282239                    | Custom     | 2.15×  |
| toString()                    | 1913365     | 2822397                   | Custom     | 1.48×  |
| clear()                       | 36          | ~200000+                  | Custom     | >5000× |

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



























