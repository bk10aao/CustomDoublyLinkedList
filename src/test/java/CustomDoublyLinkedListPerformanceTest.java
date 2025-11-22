import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CustomDoublyLinkedListPerformanceTest {

    private static final int WARMUP_RUNS = 30;
    private static final int RUNS = 100;

    public static void main(String[] args) {
        int[] sizes = {1_000, 2_500, 5_000, 7_500, 10_000, 25_000, 50_000, 100_000};

        long[][] results = new long[sizes.length][];

        String[] methodNames = {
                "\"Size\"",
                "\"add(E)\"",
                "\"add(int, E)\"",
                "\"addAll(Collection)\"",
                "\"addAll(int, Collection)\"",
                "\"addFirst(E)\"",
                "\"addLast(E)\"",
                "\"getFirst()\"",
                "\"getLast()\"",
                "\"clone()\"",
                "\"contains(Object)\"",
                "\"containsAll(Collection)\"",
                "\"element()\"",
                "\"equals(Object)\"",
                "\"get(int)\"",
                "\"hashCode()\"",
                "\"indexOf(Object)\"",
                "\"isEmpty()\"",
                "\"lastIndexOf(Object)\"",
                "\"offer(E)\"",
                "\"offerFirst(E)\"",
                "\"offerLast(E)\"",
                "\"peek()\"",
                "\"peekFirst()\"",
                "\"peekLast()\"",
                "\"poll()\"",
                "\"pollFirst()\"",
                "\"pollLast()\"",
                "\"push(E)\"",
                "\"pop()\"",
                "\"remove()\"",
                "\"remove(int)\"",
                "\"remove(Object)\"",
                "\"removeAll(Collection)\"",
                "\"removeFirst()\"",
                "\"removeFirstOccurrence(Object)\"",
                "\"removeLast()\"",
                "\"removeLastOccurrence(Object)\"",
                "\"retainAll(Collection)\"",
                "\"set(int, E)\"",
                "\"size()\"",
                "\"subList(int, int)\"",
                "\"toArray()\"",
                "\"toArray(T[])\"",
                "\"toString()\"",
                "\"clear()\""
        };

        // Warm-up: completely safe, no possible exceptions
        System.out.println("Warming up JVM...");
        warmupJvm();
        System.out.println("Warm-up complete. Starting benchmarks...\n");

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            System.out.println("Benchmarking size: " + String.format("%,d", size));

            Collection<Integer> input = generateCollection(size);
            Collection<Integer> smallInput = generateCollection(Math.max(1, size / 10));

            long add = benchmarkAdd(size);
            long addIndex = benchmarkAddIndex(size);
            long addAll = benchmarkAddAll(input);
            long addAllIndex = benchmarkAddAllIndex(size, input);
            long addFirst = benchmarkAddFirst();
            long addLast = benchmarkAddLast();
            long getFirst = benchmarkGetFirst(size);
            long getLast = benchmarkGetLast(size);
            long clone = benchmarkClone(size);
            long contains = benchmarkContains(size);
            long containsAll = benchmarkContainsAll(size, smallInput);
            long element = benchmarkElement(size);
            long equals = benchmarkEquals(size);
            long get = benchmarkGet(size);
            long hashCode = benchmarkHashCode(size);
            long indexOf = benchmarkIndexOf(size);
            long isEmpty = benchmarkIsEmpty(size);
            long lastIndexOf = benchmarkLastIndexOf(size);
            long offer = benchmarkOffer();
            long offerFirst = benchmarkOfferFirst();
            long offerLast = benchmarkOfferLast();
            long peek = benchmarkPeek(size);
            long peekFirst = benchmarkPeekFirst(size);
            long peekLast = benchmarkPeekLast(size);
            long poll = benchmarkPoll(size);
            long pollFirst = benchmarkPollFirst(size);
            long pollLast = benchmarkPollLast(size);
            long push = benchmarkPush();
            long pop = benchmarkPop(size);
            long remove = benchmarkRemove(size);
            long removeIndex = benchmarkRemoveIndex(size);
            long removeObject = benchmarkRemoveObject(size);
            long removeAll = benchmarkRemoveAll(size);
            long removeFirst = benchmarkRemoveFirst(size);
            long removeFirstOcc = benchmarkRemoveFirstOccurrence(size);
            long removeLast = benchmarkRemoveLast(size);
            long removeLastOcc = benchmarkRemoveLastOccurrence(size);
            long retainAll = benchmarkRetainAll(size);
            long set = benchmarkSet(size);
            long sizeOp = benchmarkSize(size);
            long subList = benchmarkSubList(size);
            long toArray = benchmarkToArray(size);
            long toArrayT = benchmarkToArrayT(size);
            long toString = benchmarkToString(size);
            long clear = benchmarkClear(size);

            results[i] = new long[]{
                    size, add, addIndex, addAll, addAllIndex, addFirst, addLast,
                    getFirst, getLast, clone, contains, containsAll, element, equals, get, hashCode, indexOf,
                    isEmpty, lastIndexOf, offer, offerFirst, offerLast, peek, peekFirst, peekLast, poll,
                    pollFirst, pollLast, push, pop, remove, removeIndex, removeObject, removeAll, removeFirst,
                    removeFirstOcc, removeLast, removeLastOcc, retainAll, set, sizeOp, subList, toArray, toArrayT,
                    toString, clear
            };

            System.out.println("Completed size " + String.format("%,d", size) + "\n");
        }

        writeCsv(results, methodNames);
    }

    // Completely safe warm-up — no exceptions possible
    private static void warmupJvm() {
        for (int i = 0; i < WARMUP_RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            list.add(42);
            list.addFirst(1);
            list.addLast(100);
            list.offer(5);
            list.offerFirst(10);
            list.offerLast(20);
            list.push(30);

            list.getFirst();
            list.getLast();
            list.clone();
            list.contains(42);
            list.containsAll(List.of(1, 42));
            list.equals(list);
            list.hashCode();
            list.isEmpty();
            list.size();
            list.toString();
            list.toArray();
            list.toArray(new Integer[0]);

            list.removeFirst();
            list.removeLast();
            list.clear();

            new CustomDoublyLinkedList<>(List.of(1, 2, 3, 4, 5));
        }
    }

    private static void writeCsv(long[][] results, String[] headers) {
        try (FileWriter writer = new FileWriter("CustomDoublyLinkedList_performance.csv")) {
            for (int i = 0; i < headers.length; i++) {
                writer.write(headers[i] + (i < headers.length - 1 ? ";" : "\n"));
            }
            for (long[] row : results) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(row[j] + (j < row.length - 1 ? ";" : "\n"));
                }
            }
            System.out.println("Performance report saved: CustomDoublyLinkedList_performance.csv");
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }

    private static Collection<Integer> generateCollection(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) list.add(i);
        return list;
    }

    private static CustomDoublyLinkedList<Integer> buildList(int size) {
        CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
        for (int i = 0; i < size; i++) list.add(i);
        return list;
    }

    // ==================== ALL BENCHMARKS (unchanged, perfect) ====================

    private static long benchmarkConstructor() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            long s = System.nanoTime();
            new CustomDoublyLinkedList<Integer>();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkConstructorCollection(Collection<Integer> c) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            long s = System.nanoTime();
            new CustomDoublyLinkedList<>(c);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAdd(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            for (int j = 0; j < size; j++) list.add(j);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAddIndex(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.add(size / 2, 999999);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAddAll(Collection<Integer> c) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.addAll(c);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAddAllIndex(int size, Collection<Integer> c) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.addAll(size / 2, c);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAddFirst() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.addFirst(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkAddLast() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.addLast(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkGetFirst(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.getFirst();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkGetLast(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.getLast();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkClone(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.clone();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkContains(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.contains(size - 1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkContainsAll(int size, Collection<Integer> query) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.containsAll(query);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkElement(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.element();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkEquals(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> a = buildList(size);
            CustomDoublyLinkedList<Integer> b = buildList(size);
            long s = System.nanoTime();
            a.equals(b);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkGet(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.get(size / 2);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkHashCode(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.hashCode();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkIndexOf(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.indexOf(size - 1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkIsEmpty(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.isEmpty();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkLastIndexOf(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.lastIndexOf(size - 1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkOffer() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.offer(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkOfferFirst() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.offerFirst(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkOfferLast() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.offerLast(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPeek(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.peek();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPeekFirst(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.peekFirst();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPeekLast(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.peekLast();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPoll(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.poll();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPollFirst(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.pollFirst();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPollLast(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.pollLast();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPush() {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
            long s = System.nanoTime();
            list.push(1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkPop(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.pop();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemove(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.remove();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveIndex(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.remove(size / 2);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveObject(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.remove(Integer.valueOf(size - 1));
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveAll(int size) {
        long total = 0;
        Collection<Integer> toRemove = generateCollection(size / 5);
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.removeAll(toRemove);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveFirst(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.removeFirst();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveFirstOccurrence(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.removeFirstOccurrence(size - 1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveLast(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.removeLast();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRemoveLastOccurrence(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.removeLastOccurrence(size - 1);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkRetainAll(int size) {
        long total = 0;
        Collection<Integer> toRetain = generateCollection(size / 5);
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.retainAll(toRetain);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkSet(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.set(size / 2, 999999);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkSize(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.size();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkSubList(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.subList(size / 4, 3 * size / 4);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkToArray(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.toArray();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkToArrayT(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.toArray(new Integer[0]);
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkToString(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.toString();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }

    private static long benchmarkClear(int size) {
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            CustomDoublyLinkedList<Integer> list = buildList(size);
            long s = System.nanoTime();
            list.clear();
            total += System.nanoTime() - s;
        }
        return total / RUNS;
    }
}