package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"unused", "unchecked"})
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(2)
public class LinkedListJmhBenchmark {

    @Param({"5000", "10000", "15000", "20000", "25000", "30000", "35000", "40000", "45000", "50000"})
    public int size;

    private LinkedList<Integer> list;
    private Collection<Integer> inputCollection;
    private Collection<Integer> smallInputCollection;
    private Collection<Integer> toRemoveCollection;
    private Collection<Integer> toRetainCollection;

    @Setup(Level.Trial)
    public void setupTrial() {
        inputCollection = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            inputCollection.add(i);
        }

        smallInputCollection = new ArrayList<>(Math.max(1, size / 10));
        for (int i = 0; i < Math.max(1, size / 10); i++) {
            smallInputCollection.add(i);
        }

        toRemoveCollection = new ArrayList<>(size / 5);
        for (int i = 0; i < size / 5; i++) {
            toRemoveCollection.add(i);
        }

        toRetainCollection = new ArrayList<>(size / 5);
        for (int i = 0; i < size / 5; i++) {
            toRetainCollection.add(i);
        }
    }

    @Setup(Level.Invocation)
    public void setupInvocation() {
        list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public LinkedList<Integer> benchmarkConstructor() {
        return new LinkedList<>();
    }

    @Benchmark
    public LinkedList<Integer> benchmarkConstructorCollection() {
        return new LinkedList<>(inputCollection);
    }

    @Benchmark
    public LinkedList<Integer> benchmarkAdd() {
        LinkedList<Integer> l = new LinkedList<>();
        for (int j = 0; j < size; j++) {
            l.add(j);
        }
        return l;
    }

    @Benchmark
    public void benchmarkAddIndex() {
        list.add(size / 2, 999999);
    }

    @Benchmark
    public boolean benchmarkAddAll() {
        LinkedList<Integer> l = new LinkedList<>();
        return l.addAll(inputCollection);
    }

    @Benchmark
    public boolean benchmarkAddAllIndex() {
        return list.addAll(size / 2, inputCollection);
    }

    @Benchmark
    public void benchmarkAddFirst() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addFirst(1);
    }

    @Benchmark
    public void benchmarkAddLast() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addLast(1);
    }

    @Benchmark
    public Integer benchmarkGetFirst() {
        return list.getFirst();
    }

    @Benchmark
    public Integer benchmarkGetLast() {
        return list.getLast();
    }

    @Benchmark
    public LinkedList<Integer> benchmarkClone() {
        return (LinkedList<Integer>) list.clone();
    }

    @Benchmark
    public boolean benchmarkContains() {
        return list.contains(size - 1);
    }

    @Benchmark
    public boolean benchmarkContainsAll() {
        return list.containsAll(smallInputCollection);
    }

    @Benchmark
    public Integer benchmarkElement() {
        return list.element();
    }

    @Benchmark
    public boolean benchmarkEquals() {
        LinkedList<Integer> other = new LinkedList<>();
        for (int i = 0; i < size; i++) other.add(i);
        return list.equals(other);
    }

    @Benchmark
    public Integer benchmarkGet() {
        return list.get(size / 2);
    }

    @Benchmark
    public int benchmarkHashCode() {
        return list.hashCode();
    }

    @Benchmark
    public int benchmarkIndexOf() {
        return list.indexOf(size - 1);
    }

    @Benchmark
    public boolean benchmarkIsEmpty() {
        return list.isEmpty();
    }

    @Benchmark
    public int benchmarkLastIndexOf() {
        return list.lastIndexOf(size - 1);
    }

    @Benchmark
    public boolean benchmarkOffer() {
        LinkedList<Integer> l = new LinkedList<>();
        return l.offer(1);
    }

    @Benchmark
    public void benchmarkOfferFirst() {
        LinkedList<Integer> l = new LinkedList<>();
        l.offerFirst(1);
    }

    @Benchmark
    public void benchmarkOfferLast() {
        LinkedList<Integer> l = new LinkedList<>();
        l.offerLast(1);
    }

    @Benchmark
    public Integer benchmarkPeek() {
        return list.peek();
    }

    @Benchmark
    public Integer benchmarkPeekFirst() {
        return list.peekFirst();
    }

    @Benchmark
    public Integer benchmarkPeekLast() {
        return list.peekLast();
    }

    @Benchmark
    public Integer benchmarkPoll() {
        return list.poll();
    }

    @Benchmark
    public Integer benchmarkPollFirst() {
        return list.pollFirst();
    }

    @Benchmark
    public Integer benchmarkPollLast() {
        return list.pollLast();
    }

    @Benchmark
    public void benchmarkPush() {
        LinkedList<Integer> l = new LinkedList<>();
        l.push(1);
    }

    @Benchmark
    public Integer benchmarkPop() {
        return list.pop();
    }

    @Benchmark
    public Integer benchmarkRemove() {
        return list.remove();
    }

    @Benchmark
    public Integer benchmarkRemoveIndex() {
        return list.remove(size / 2);
    }

    @Benchmark
    public boolean benchmarkRemoveObject() {
        return list.remove(Integer.valueOf(size - 1));
    }

    @Benchmark
    public boolean benchmarkRemoveAll() {
        return list.removeAll(toRemoveCollection);
    }

    @Benchmark
    public Integer benchmarkRemoveFirst() {
        return list.removeFirst();
    }

    @Benchmark
    public boolean benchmarkRemoveFirstOccurrence() {
        return list.removeFirstOccurrence(size - 1);
    }

    @Benchmark
    public Integer benchmarkRemoveLast() {
        return list.removeLast();
    }

    @Benchmark
    public boolean benchmarkRemoveLastOccurrence() {
        return list.removeLastOccurrence(size - 1);
    }

    @Benchmark
    public boolean benchmarkRetainAll() {
        return list.retainAll(toRetainCollection);
    }

    @Benchmark
    public Integer benchmarkSet() {
        return list.set(size / 2, 999999);
    }

    @Benchmark
    public int benchmarkSize() {
        return list.size();
    }

    @Benchmark
    public List<Integer> benchmarkSubList() {
        return list.subList(size / 4, 3 * size / 4);
    }

    @Benchmark
    public Object[] benchmarkToArray() {
        return list.toArray();
    }

    @Benchmark
    public Integer[] benchmarkToArrayT() {
        return list.toArray(new Integer[0]);
    }

    @Benchmark
    public String benchmarkToString() {
        return list.toString();
    }

    @Benchmark
    public void benchmarkClear() {
        list.clear();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LinkedListJmhBenchmark.class.getSimpleName())
                .build();

        Collection<RunResult> results = new Runner(opt).run();
        writeCustomCsv(results);
    }

    private static void writeCustomCsv(Collection<RunResult> results) {
        try (FileWriter writer = new FileWriter("LinkedList_jmh_performance.csv")) {
            writer.write("Benchmark;Size;Score (ns/op)\n");
            for (RunResult result : results) {
                String benchmarkName = result.getParams().getBenchmark();
                String shortName = benchmarkName.substring(benchmarkName.lastIndexOf('.') + 1);

                double score = result.getPrimaryResult().getScore();
                String sizeVal = result.getParams().getParam("size");

                writer.write("\"" + shortName + "\";" + (sizeVal != null ? sizeVal : "N/A") + ";" + score + "\n");
            }
            System.out.println("JMH Performance report saved: LinkedList_jmh_performance.csv");
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}