import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A custom doubly-linked list implementation that maintains elements in insertion order.
 * This list does not permit null elements in add operations and throws a {@link NullPointerException}.
 * It implements the {@link CustomDoublyLinkedListInterface} for standard list operations and supports iteration via {@link Iterable}.
 * <p>
 * This implementation provides O(1) time complexity for operations at the head and tail (e.g.,
 * {@code addFirst}, {@code addLast}, {@code removeFirst}, {@code removeLast}) and O(n/2) average
 * for indexed operations (e.g., {@code get(int)}, {@code set(int, E)}). It is not thread-safe.
 * <p>
 * @param <E> the type of elements maintained by this list
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn Profile</a>
 * @see <a href="https://github.com/bk10aao">GitHub Account</a>
 * @see <a href="https://github.com/bk10aao/CustomDoublyLinkedList">Repository</a>
 */
public class CustomDoublyLinkedList<E> implements CustomDoublyLinkedListInterface<E> {

    private Node head;
    private Node tail;

    private int size = 0;

    /**
     * Constructs an empty doubly-linked list with no elements.
     * Initializes the list with {@code size = 0}, {@code head = null}, and {@code tail = null}.
     */
    public CustomDoublyLinkedList() { }

    /**
     * Constructs a doubly-linked list containing the elements of the specified collection,
     * added in the order they are returned by the collection's iterator.
     *
     * @param items the collection of elements to add to the list
     *
     * @throws NullPointerException if the collection or any element is null
     */
    public CustomDoublyLinkedList(final Collection<E> items) {
        if(items == null)
            throw new NullPointerException("Null collection not supported");
        for (E item : items) {
            if (item == null)
                throw new NullPointerException();
            Node node = new Node(item);
            if (tail == null)
                head = node;
            else {
                tail.next = node;
                node.previous = tail;
            }
            tail = node;
            size++;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be added to the list
     *
     * @return {@code true} (as specified by {@link java.util.List#add(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean add(final E item) {
        if(item == null)
            throw new NullPointerException();
        Node node = new Node(item);
        if (tail == null)
            head = node;
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified index in this list.
     * Shifts the element currently at that index (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index the index at which to insert the element
     * @param item the element to be inserted
     *
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     */
    public void add(final int index, final E item) {
        if (item == null)
            throw new NullPointerException();
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            addFirst(item);
        else if(index == size)
            add(item);
        else
            addToIndex(item, index > size / 2 ? getNodeByIndexFromTail(index) : getFromHead(index));
    }

    /**
     * Appends all elements in the specified collection to the end of this list,
     * in the order they are returned by the collection's iterator.
     *
     * @param collection the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     */
    public boolean addAll(final Collection<E> collection) {
        if(collection == null)
            throw new NullPointerException();
        int startSize = size;
        collection.forEach(this::add);
        return startSize != size;
    }

    /**
     * Inserts all elements in the specified collection into this list at the specified index,
     * in the order they are returned by the collection's iterator. Shifts the element currently
     * at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which to insert the first element from the collection
     * @param collection the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     */
    public boolean addAll(final int index, final Collection<E> collection) {
        if (collection == null)
            throw new NullPointerException("Null collection not supported");
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (collection.isEmpty())
            return false;
        Node first = null;
        Node last = null;
        int count = 0;
        for (E item : collection) {
            if (item == null)
                throw new NullPointerException();
            Node newNode = new Node(item);
            if (first == null)
                first = newNode;
            else {
                last.next = newNode;
                newNode.previous = last;
            }
            last = newNode;
            count++;
        }
        if (index == 0) {
            last.next = head;
            if (head != null)
                head.previous = last;
            head = first;
            if (size == 0)
                tail = last;
        } else if (index == size) {
            tail.next = first;
            first.previous = tail;
            tail = last;
        } else {
            Node node = index > size / 2 ? getNodeByIndexFromTail(index) : getFromHead(index);
            first.previous = node.previous;
            if (node.previous != null)
                node.previous.next = first;
            last.next = node;
            node.previous = last;
        }
        size += count;
        return true;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item the element to be added to the head of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void addFirst(final E item) {
        if (item == null)
            throw new NullPointerException();
        Node node = new Node(item);
        if(head == null)
            head = tail = node;
        else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #add(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void addLast(final E item) {
        add(item);
    }

    /**
     * Removes all elements from this list, setting its size to zero and
     * resetting the head and tail to {@code null}.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Creates and returns a shallow copy of this {@code CustomDoublyLinkedList}.
     * The new list contains the same elements as this list, in the same order,
     * but modifications to the elements themselves (if mutable) will affect both lists.
     * The internal structure (nodes) of the new list is independent of this list.
     *
     * @return a new {@code CustomDoublyLinkedList} instance containing all elements of this list
     *
     * @throws OutOfMemoryError if there is insufficient memory to create the clone
     */
    @Override
    public CustomDoublyLinkedList<E> clone() {
        CustomDoublyLinkedList<E> clone = new CustomDoublyLinkedList<>();
        for (Node x = head; x != null; x = x.next)
            clone.add(x.data);
        return clone;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains at least
     * one element {@code e} such that {@code Objects.equals(item, e)}.
     *
     * @param item the element to search for (may be null)
     *
     * @return {@code true} if the element is present in the list, {@code false} otherwise
     */
    public boolean contains(final E item) {
        return indexOf(item) != -1;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Compares the specified object with this list for equality.
     * Returns {@code true} if and only if the specified object is also a
     * {@code CustomDoublyLinkedList}, both lists have the same size, and all
     * corresponding pairs of elements in the two lists are equal according to
     * {@link Objects#equals(Object, Object)}. In other words, two lists are
     * considered equal if they contain the same elements in the same order.
     * This implementation allows comparison with any {@code CustomDoublyLinkedList}
     * regardless of its generic type.
     *
     * @param o the object to be compared for equality with this list
     *
     * @return {@code true} if the specified object is equal to this list,
     *         {@code false} otherwise
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomDoublyLinkedList<?> that))
            return false;
        if (size != that.size)
            return false;
        Node thisNode = head;
        Node thatNode = (Node) that.head;
        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.data, thatNode.data))
                return false;
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        return thisNode == null && thatNode == null;
    }

    /**
     * Returns the element at the specified index in this list. Uses bidirectional
     * traversal for efficiency, starting from the head or tail based on index proximity.
     *
     * @param index the index of the element to return
     *
     * @return the element at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public E get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            return head.data;
        if(index == size - 1)
            return tail.data;
        return (index > size / 2) ? getFromTail(index) : getFromHead(index).data;
    }

    /**
     * Returns the hash code value for this list.
     * The hash code is computed based on the hash codes of all elements in the list,
     * using the standard list hash code formula:
     * {@code 1 + 31 * (element1.hashCode()) + 31^2 * (element2.hashCode()) + ...}.
     * This ensures that {@code list1.equals(list2)} implies
     * {@code list1.hashCode() == list2.hashCode()} for any two lists, as required
     * by the general contract of {@link Object#hashCode()}.
     *
     * @return the hash code value for this list
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (Node x = head; x != null; x = x.next)
            result = 31 * result + Objects.hashCode(x.data);
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if the element is not present.
     *
     * @param item the element to search for (may be null)
     *
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(final E item) {
        int index = 0;
        for (Node x = head; x != null; x = x.next, index++)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an {@code Iterator} over the elements in this list
     */
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node node = head;
            private Node lastReturned = null;

            public boolean hasNext() {
                return node != null;
            }

            public E next() {
                if (node == null)
                    throw new NoSuchElementException();
                lastReturned = node;
                E data = node.data;
                node = node.next;
                return data;
            }

            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException();
                CustomDoublyLinkedList.this.getFromIndex(lastReturned);
                lastReturned = null;
            }
        };
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if the element is not present. Uses {@link Objects#equals(Object, Object)}
     * for comparison.
     *
     * @param item the element to search for (may be null)
     *
     * @return the index of the last occurrence of the element, or -1 if not found
     */
    public int lastIndexOf(final E item) {
        int index = size - 1;
        for (Node x = tail; x != null; x = x.previous, index--)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #add(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @return {@code true} (as specified by {@link java.util.Queue#offer(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offer(final E item) {
        return add(item);
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * This method is equivalent to {@link #addFirst(Object)}.
     *
     * @param item the element to be added to the head of the list
     *
     * @return {@code true} (as specified by {@link java.util.Deque#offerFirst(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offerFirst(final E item) {
        if (item == null)
            throw new NullPointerException();
        addFirst(item);
        return true;
    }

    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to {@link #addLast(Object)}.
     *
     * @param item the element to be added to the end of the list
     *
     * @return {@code true} (as specified by {@link java.util.Deque#offerLast(Object)})
     *
     * @throws NullPointerException if the element is null
     */
    public boolean offerLast(final E item) {
        if (item == null)
            throw new NullPointerException();
        addLast(item);
        return true;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E peek() {
        return size == 0 ? null : head.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * This method is equivalent to {@link #peek()}.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E peekFirst() {
        return peek();
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return the element at the end of the list, or {@code null} if the list is empty
     */
    public E peekLast() {
        return size == 0 ? null : tail.data;
    }

    /**
     * Removes and returns the head (first element) of this list.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E poll() {
        return size != 0 ? removeFirst() : null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()}.
     *
     * @return the element at the head of the list, or {@code null} if the list is empty
     */
    public E pollFirst() {
        return poll();
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return the element at the end of the list, or {@code null} if the list is empty
     */
    public E pollLast() {
        return size != 0 ? removeLast() : null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E pop() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * This method is equivalent to {@link #addFirst(Object)}.
     *
     * @param item the element to be added to the head of the list
     *
     * @throws NullPointerException if the element is null
     */
    public void push(final E item) {
        addFirst(item);
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * Removes the element at the specified index in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     *
     * @return the element that was removed
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws IllegalStateException if the list structure is inconsistent
     */
    public E remove(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return removeFirst();
        else if(index == size - 1)
            return removeLast();
        Node node = index > size / 2 ? getNodeByIndexFromTail(index) : getFromHead(index);
        return getFromIndex(node);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     *
     * @param item the element to be removed (may be null)
     *
     * @return the element that was removed, or {@code null} if the element was not found
     */
    public E remove(final E item) {
        for(Node node = head; node != null; node = node.next)
            if (Objects.equals(node.data, item))
                return getFromIndex(node);
        return null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return the element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        E previous = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return previous;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     *
     * @param item the element to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    public boolean removeFirstOccurrence(final E item) {
        for(Node node = head; node != null; node = node.next)
            if (Objects.equals(node.data, item))
                return getFromIndex(node) != null;
        return false;
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return the element that was removed
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if(size == 0)
            throw new NoSuchElementException();
        E data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return data;
    }

    /**
     * Removes the last occurrence of the specified element from this list, if present.
     *
     * @param item the element to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    public boolean removeLastOccurrence(final E item) {
        for(Node node = tail; node != null; node = node.previous)
            if (Objects.equals(node.data, item))
                return getFromIndex(node) != null;
        return false;
    }

    /**
     * Replaces the element at the specified index in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param item the new element to set at the specified index
     *
     * @return the previous element at the specified index
     *
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     * @throws IllegalStateException if the list structure is inconsistent (e.g., a node is unexpectedly null)
     */
    public E set(final int index, final E item) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            E previousValue = head.data;
            head.data = item;
            return previousValue;
        } else if(index == size - 1) {
            E previouseValue = tail.data;
            tail.data = item;
            return previouseValue;
        }
        return updateIndex(index, item);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence
     * (from head to tail).
     *
     * @return an array containing the elements of this list
     *
     * @throws ArrayStoreException if the runtime type of the array elements is not
     *         compatible with the type of the elements in this list
     */
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for(Node node = head; node != null; node = node.next)
            array[index++] = node.data;
        return (E[])array;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence,
     * using the specified array if it is large enough.
     *
     * @param a the array into which the elements are to be stored, if it is large enough
     * @return an array containing the elements of this list
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int index = 0;
        for (Node node = head; node != null; node = node.next)
            a[index++] = (T) node.data;
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this list.
     * The string representation consists of the elements of the list in order,
     * enclosed in curly braces ({@code "{ }"}). Adjacent elements are separated
     * by a comma and a space ({@code ", "}). If the list is empty, returns
     * {@code "{ }"}.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        if(size == 0)
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.data).append(", ");
            node = node.next;
        }
        return stringBuilder.replace(stringBuilder.lastIndexOf(", "), stringBuilder.length(), " }").toString();
    }

    /**
     * Inserts a new node with the specified item before the given node.
     *
     * @param item the element to insert
     * @param newNode the node before which to insert the new node
     * @throws NullPointerException if the item is null
     */
    private void addToIndex(final E item, final Node newNode) {
        if (item == null)
            throw new NullPointerException();
        Node node = new Node(item);
        node.next = newNode;
        node.previous = newNode.previous;
        if (newNode.previous != null)
            newNode.previous.next = node;
        newNode.previous = node;
        size++;
    }

    private Node getNodeByIndexFromTail(final int position) {
        Node node = tail;
        for(int i = size - 1; i > position; i--) {
            if(node == null)
                throw new IllegalStateException();
            node = node.previous;
        }
        return node;
    }

    private E getFromIndex(final Node node) {
        if (node == null)
            throw new IllegalStateException("List structure corrupted");
        E data = node.data;
        node.previous.next = node.next;
        if (node.next != null)
            node.next.previous = node.previous;
        else
            tail = node.previous;
        size--;
        return data;
    }

    private Node getFromHead(final int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node == null)
                throw new IllegalStateException();
            node = node.next;
        }
        return node;
    }

    private E getFromTail(final int index) {
        Node node = tail;
        for (int i = size - 1; i > index; i--)
            node = node.previous;
        return node.data;
    }

    private E updateIndex(final int index, final E item) {
        return index > size / 2 ? updateReverse(index, item) : updateForward(index, item);
    }

    private E updateForward(final int index, final E item) {
        if(item == null)
            throw new NullPointerException();
        Node node = head;
        for(int i = 0; i < index; i++) {
            if(node == null)
                throw new IllegalStateException();
            node = node.next;
        }
        E previous = node.data;
        node.data = item;
        return previous;
    }

    private E updateReverse(final int index, final E item) {
        if(item == null)
            throw new NullPointerException();
        Node node = tail;
        for(int i = size - 1; i > index; i--) {
            if(node == null)
                throw new IllegalStateException();
            node = node.previous;
        }
        E previous = node.data;
        node.data = item;
        return previous;
    }

    /**
     * A node in the doubly-linked list, containing an element and references to the previous and next nodes.
     */
    private class Node {
        private E data;
        private Node previous = null;
        private Node next = null;

        /**
         * Constructs a node with the specified element.
         *
         * @param data the element to store in this node
         */
        public Node(E data) {
            this.data = data;
        }
    }
}
