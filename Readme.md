# LinkedList
Custom implementation of a doubly LinkedList.
All methods implemented are of the [Java Linked List](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) class including the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html), [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) and [Cloneable](https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html) interfaces.

Implementation of a Singly Linked List can be found [here](https://github.com/bk10aao/CustomLinkedList).

# Time complexity

| Method                                       |    `V1`    |      `V2`      |     `JDK`      | Winner  |
|:---------------------------------------------|:----------:|:--------------:|:--------------:|:-------:|
| `add(E)`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `add(int index, E)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `addAll(Collection<? extends E>)`            |   $O(m)$   |     $O(m)$     |     $O(m)$     |   Tie   |
| `addAll(int index, Collection<? extends E>)` | $O(n + m)$ | $O(n / 2 + m)$ | $O(n / 2 + m)$ | V2, JDK |
| `addFirst(E)`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `addLast(E)`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `clear()`                                    |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `clone()`                                    |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `contains(Object)`                           |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `element()`                                  |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `get(int index)`                             |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `indexOf(Object)`                            |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `isEmpty()`                                  |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `iterator()`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `lastIndexOf(Object)`                        |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `listIterator()`                             |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `listIterator(int index)`                    |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `offer(E)`                                   |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `offerFirst(E)`                              |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `offerLast(E)`                               |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peek()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peekFirst()`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peekLast()`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `poll()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `pollFirst()`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `pollLast()`                                 |   $O(n)$   |     $O(1)$     |     $O(1)$     | V2, JDK |
| `pop()`                                      |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `push(E)`                                    |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `remove(int index)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `remove(Object o)`                           |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `removeFirst()`                              |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `removeFirstOccurrence(Object)`              |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `removeLast()`                               |   $O(n)$   |     $O(1)$     |     $O(1)$     | V2, JDK |
| `removeLastOccurrence(Object)`               |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `set(int index, E)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `size()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `subList(int fromIndex, int toIndex)`        |   $O(k)$   | $O(1)$ (View)  | $O(1)$ (View)  | V2, JDK |
| `toArray()`                                  |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `toArray(T[] a)`                             |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `toString()`                                 |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |

# Space complexity

| Method                                       |    `V1`    |      `V2`      |     `JDK`      | Winner  |
|:---------------------------------------------|:----------:|:--------------:|:--------------:|:-------:|
| `add(E)`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `add(int index, E)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `addAll(Collection<? extends E>)`            |   $O(m)$   |     $O(m)$     |     $O(m)$     |   Tie   |
| `addAll(int index, Collection<? extends E>)` | $O(n + m)$ | $O(n / 2 + m)$ | $O(n / 2 + m)$ | V2, JDK |
| `addFirst(E)`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `addLast(E)`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `clear()`                                    |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `clone()`                                    |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `contains(Object)`                           |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `element()`                                  |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `get(int index)`                             |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `indexOf(Object)`                            |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `isEmpty()`                                  |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `iterator()`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `lastIndexOf(Object)`                        |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `listIterator()`                             |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `listIterator(int index)`                    |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `offer(E)`                                   |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `offerFirst(E)`                              |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `offerLast(E)`                               |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peek()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peekFirst()`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `peekLast()`                                 |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `poll()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `pollFirst()`                                |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `pollLast()`                                 |   $O(n)$   |     $O(1)$     |     $O(1)$     | V2, JDK |
| `pop()`                                      |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `push(E)`                                    |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `remove(int index)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `remove(Object o)`                           |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `removeFirst()`                              |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `removeFirstOccurrence(Object)`              |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `removeLast()`                               |   $O(n)$   |     $O(1)$     |     $O(1)$     | V2, JDK |
| `removeLastOccurrence(Object)`               |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `set(int index, E)`                          |   $O(n)$   |   $O(n / 2)$   |   $O(n / 2)$   | V2, JDK |
| `size()`                                     |   $O(1)$   |     $O(1)$     |     $O(1)$     |   Tie   |
| `subList(int fromIndex, int toIndex)`        |   $O(k)$   | $O(1)$ (View)  | $O(1)$ (View)  | V2, JDK |
| `toArray()`                                  |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `toArray(T[] a)`                             |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |
| `toString()`                                 |   $O(n)$   |     $O(n)$     |     $O(n)$     |   Tie   |

* **$n$**: The total number of elements currently stored in the linked list.
* **$m$**: The number of elements contained in the collection.
* **$k$**: The number of elements in the specified sublist range (`toIndex - fromIndex`).

# Performance

## V2 vs JDK

| Method                          | V2 (ns)   | JDK (ns)  |  Ratio  |            Winner            |
|:--------------------------------|:----------|:----------|:-------:|:----------------------------:|
| `add(E)`                        | 852804    | 880547    | ~1.03×  | **Statistically Equivalent** |
| `add(int, E)`                   | 253095    | 261645    | ~1.03×  | **Statistically Equivalent** |
| `addAll(Collection)`            | 605767    | 506558    |  1.20×  |        **LinkedList**        |
| `addAll(int, Collection)`       | 861532    | 758533    |  1.14×  |        **LinkedList**        |
| `addFirst(E)`                   | 236       | 301       |  1.28×  |            **V2**            |
| `addLast(E)`                    | 200       | 213       |  1.06×  | **Statistically Equivalent** |
| `clear()`                       | 448473    | 448279    | ~1.00×  | **Statistically Equivalent** |
| `clone()`                       | 586322    | 615020    | ~1.05×  | **Statistically Equivalent** |
| `contains(Object)`              | 635631    | 553031    |  1.15×  |        **LinkedList**        |
| `containsAll(Collection)`       | 144338110 | 96892540  |  1.49×  |        **LinkedList**        |
| `element()`                     | 281       | 280       | ~1.00×  | **Statistically Equivalent** |
| `equals(Object)`                | 1787025   | 1888869   |  1.06×  | **Statistically Equivalent** |
| `get(int)`                      | 253876    | 257732    | ~1.02×  | **Statistically Equivalent** |
| `getFirst()`                    | 299       | 276       |  1.08×  | **Statistically Equivalent** |
| `getLast()`                     | 293       | 267       |  1.10×  | **Statistically Equivalent** |
| `hashCode()`                    | 468061    | 463363    | ~1.01×  | **Statistically Equivalent** |
| `indexOf(Object)`               | 579899    | 575530    | ~1.01×  | **Statistically Equivalent** |
| `isEmpty()`                     | 284       | 344       |  1.21×  |            **V2**            |
| `lastIndexOf(Object)`           | 325       | 330       | ~1.02×  | **Statistically Equivalent** |
| `offer(E)`                      | 284       | 310       |  1.09×  | **Statistically Equivalent** |
| `offerFirst(E)`                 | 230       | 397       |  1.73×  |            **V2**            |
| `offerLast(E)`                  | 233       | 271       |  1.16×  |            **V2**            |
| `peek()`                        | 315       | 328       | ~1.04×  | **Statistically Equivalent** |
| `peekFirst()`                   | 322       | 297       |  1.08×  | **Statistically Equivalent** |
| `peekLast()`                    | 273       | 327       |  1.20×  |            **V2**            |
| `poll()`                        | 339       | 341       | ~1.01×  | **Statistically Equivalent** |
| `pollFirst()`                   | 291       | 487       |  1.67×  |            **V2**            |
| `pollLast()`                    | 270       | 346       |  1.28×  |            **V2**            |
| `pop()`                         | 277       | 344       |  1.24×  |            **V2**            |
| `push(E)`                       | 207       | 250       |  1.21×  |            **V2**            |
| `remove()`                      | 273       | 399       |  1.46×  |            **V2**            |
| `remove(int)`                   | 254938    | 308913    |  1.21×  |            **V2**            |
| `remove(Object)`                | 580650    | 566418    | ~1.03×  | **Statistically Equivalent** |
| `removeAll(Collection)`         | 1455654   | 922613553 | 633.81× |            **V2**            |
| `removeFirst()`                 | 270       | 366       |  1.36×  |            **V2**            |
| `removeFirstOccurrence(Object)` | 575207    | 601290    | ~1.05×  | **Statistically Equivalent** |
| `removeLast()`                  | 274       | 387       |  1.41×  |            **V2**            |
| `removeLastOccurrence(Object)`  | 320       | 315       | ~1.02×  | **Statistically Equivalent** |
| `retainAll(Collection)`         | 1591015   | 901699327 | 566.74× |            **V2**            |
| `set(int, E)`                   | 258487    | 271614    |  1.05×  | **Statistically Equivalent** |
| `size()`                        | 294       | 315       |  1.07×  | **Statistically Equivalent** |
| `subList(int, int)`             | 296       | 336       |  1.14×  |            **V2**            |
| `toArray()`                     | 437483    | 482643    |  1.10×  | **Statistically Equivalent** |
| `toArray(T[])`                  | 478357    | 519899    |  1.09×  | **Statistically Equivalent** |
| `toString()`                    | 4604379   | 4120345   |  1.12×  |        **LinkedList**        |

## V1 vs V2


| Method                          | V1 (ns)     | V2 (ns)     | Ratio        |            Winner            |
|:--------------------------------|:------------|:------------|:-------------|:----------------------------:|
| `add(E)`                        | 837505      | 852804      | ~1.02x       | **Statistically Equivalent** |
| `add(int, E)`                   | 254893      | 253095      | ~1.01x       | **Statistically Equivalent** |
| `addAll(Collection)`            | 605322      | 605767      | ~1.00x       | **Statistically Equivalent** |
| `addAll(int, Collection)`       | 17379300399 | 861532      | 20172.55x    |            **V2**            |
| `addFirst(E)`                   | 220         | 236         | ~1.07x       | **Statistically Equivalent** |
| `addLast(E)`                    | 215         | 200         | ~1.07x       | **Statistically Equivalent** |
| `clear()`                       | 206         | 448473      | 2177.05x     |            **V1**            |
| `clone()`                       | 544903      | 586322      | ~1.08x       | **Statistically Equivalent** |
| `contains(Object)`              | 630094      | 635631      | ~1.01x       | **Statistically Equivalent** |
| `containsAll(Collection)`       | 148240843   | 144338110   | ~1.03x       | **Statistically Equivalent** |
| `element()`                     | 322         | 281         | 1.15x        |            **V2**            |
| `equals(Object)`                | 1644949     | 1787025     | ~1.09x       | **Statistically Equivalent** |
| `get(int)`                      | 252529      | 253876      | ~1.01x       | **Statistically Equivalent** |
| `getFirst()`                    | 304         | 299         | ~1.02x       | **Statistically Equivalent** |
| `getLast()`                     | 297         | 293         | ~1.01x       | **Statistically Equivalent** |
| `hashCode()`                    | 562927      | 468061      | 1.20x        |            **V2**            |
| `indexOf(Object)`               | 577821      | 579899      | ~1.00x       | **Statistically Equivalent** |
| `isEmpty()`                     | 294         | 284         | ~1.04x       | **Statistically Equivalent** |
| `lastIndexOf(Object)`           | 908763      | 325         | 2796.19x     |            **V2**            |
| `offer(E)`                      | 322         | 284         | 1.13x        |            **V2**            |
| `offerFirst(E)`                 | 215         | 230         | ~1.07x       | **Statistically Equivalent** |
| `offerLast(E)`                  | 215         | 233         | ~1.08x       | **Statistically Equivalent** |
| `peek()`                        | 346         | 315         | ~1.10x       | **Statistically Equivalent** |
| `peekFirst()`                   | 299         | 322         | ~1.08x       | **Statistically Equivalent** |
| `peekLast()`                    | 472         | 273         | 1.73x        |            **V2**            |
| `poll()`                        | 344         | 339         | ~1.01x       | **Statistically Equivalent** |
| `pollFirst()`                   | 327         | 291         | 1.12x        |            **V2**            |
| `pollLast()`                    | 509237      | 270         | 1886.06x     |            **V2**            |
| `pop()`                         | 313         | 277         | 1.13x        |            **V2**            |
| `push(E)`                       | 233         | 207         | 1.13x        |            **V2**            |
| `remove()`                      | 293         | 273         | ~1.07x       | **Statistically Equivalent** |
| `remove(Object)`                | 651906      | 580650      | 1.12x        |            **V2**            |
| `remove(int)`                   | 257863      | 254938      | ~1.01x       | **Statistically Equivalent** |
| `removeAll(Collection)`         | 1384972     | 1455654     | ~1.05x       | **Statistically Equivalent** |
| `removeFirst()`                 | 293         | 270         | ~1.09x       | **Statistically Equivalent** |
| `removeFirstOccurrence(Object)` | 632298      | 575207      | ~1.10x       | **Statistically Equivalent** |
| `removeLast()`                  | 507794      | 274         | 1853.26x     |            **V2**            |
| `removeLastOccurrence(Object)`  | 936185      | 320         | 2925.58x     |            **V2**            |
| `retainAll(Collection)`         | 1541043     | 1591015     | ~1.03x       | **Statistically Equivalent** |
| `set(int, E)`                   | 255731      | 258487      | ~1.01x       | **Statistically Equivalent** |
| `size()`                        | 270         | 294         | ~1.09x       | **Statistically Equivalent** |
| `subList(int, int)`             | 4308985927  | 296         | 14557384.89x |            **V2**            |
| `toArray()`                     | 444724      | 437483      | ~1.02x       | **Statistically Equivalent** |
| `toArray(T[])`                  | 471045      | 478357      | ~1.02x       | **Statistically Equivalent** |
| `toString()`                    | 4657348     | 4604379     | ~1.01x       | **Statistically Equivalent** |

Scores are averages across sizes 5000–50000. “Statistically Equivalent” = ratio <= 1.10×.

## Performance Charts

#### Note: The following performance charts are designed to be viewed in dark mode.

# V1 vs V2 vs JDK

## Custom Linked List vs Linked List
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_add_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_add_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_addAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_addAll_int__Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_addFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_addLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_clear__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_clone__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_contains_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_containsAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_element__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_equals_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_get_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_getFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_getLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_hashCode__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_indexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_isEmpty__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_lastIndexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_offer_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_offerFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_offerLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_peek__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_peekFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_peekLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_poll__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_pollFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_pollLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_pop__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_push_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_remove__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_remove_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_remove_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_removeAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_removeFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_removeFirstOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_removeLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_removeLastOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_retainAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_set_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_size__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_subList_int__int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_toArray__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_toArray_T[]_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2_JDK/plot_toString__.png)

# V2 vs JDK

![Heatmap](PerformanceTesting/Graphs/V2_JDK/heatmap.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_add_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_add_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_addAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_addAll_int__Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_addFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_addLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_clear__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_clone__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_contains_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_containsAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_element__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_equals_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_get_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_getFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_getLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_hashCode__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_indexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_isEmpty__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_lastIndexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_offer_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_offerFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_offerLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_peek__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_peekFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_peekLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_poll__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_pollFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_pollLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_pop__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_push_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_remove__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_remove_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_remove_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_removeAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_removeFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_removeFirstOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_removeLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_removeLastOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_retainAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_set_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_size__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_subList_int__int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_toArray__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_toArray_T[]_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V2_JDK/plot_toString__.png)

# V1 vs V2

## Custom Linked List vs Linked List
![Heatmap](PerformanceTesting/Graphs/V1_V2/heatmap.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_add_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_add_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_addAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_addAll_int__Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_addFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_addLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_clear__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_clone__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_contains_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_containsAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_element__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_equals_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_get_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_getFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_getLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_hashCode__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_indexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_isEmpty__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_lastIndexOf_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_offer_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_offerFirst_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_offerLast_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_peek__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_peekFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_peekLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_poll__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_pollFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_pollLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_pop__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_push_E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_remove__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_remove_int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_remove_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_removeAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_removeFirst__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_removeFirstOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_removeLast__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_removeLastOccurrence_Object_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_retainAll_Collection_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_set_int__E_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_size__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_subList_int__int_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_toArray__.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_toArray_T[]_.png)
![Combined Performance Charts](PerformanceTesting/Graphs/V1_V2/plot_toString__.png)

























