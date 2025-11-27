import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * A custom doubly-linked list implementation that maintains elements in insertion order.
 * This list does not permit null elements in add operations and throws a {@link NullPointerException}.
 * It implements the {@link List} interface for standard list operations and supports iteration via {@link Iterable}.
 * <p>
 * This implementation provides O(1) time complexity for operations at the head and tail (e.g.,
 * {@code addFirst}, {@code addLast}, {@code removeFirst}, {@code removeLast}) and O(n/2) average
 * for indexed operations (e.g., {@code get(int)}, {@code set(int, E)}). It is not thread-safe.
 * <strong>Note:</strong> Unlike {@link java.util.LinkedList}, this implementation
 * does <em>not</em> permit {@code null} elements. Any attempt to insert {@code null}
 * will result in a {@link NullPointerException}
 * <p>
 *
 * @param <E> the type of elements maintained by this list
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn Profile</a>
 * @see <a href="https://github.com/bk10aao">GitHub Account</a>
 * @see <a href="https://github.com/bk10aao/CustomDoublyLinkedList">Repository</a>
 */
public class CustomDoublyLinkedList<E> implements List<E>, Deque<E>, Serializable, Cloneable {

    private transient Node<E> head;
    private transient Node<E> tail;

    private transient int size = 0;

    @Serial
    private static final long serialVersionUID = 1L;

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
        requireNonNullCollection(items);
        addAll(items);
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
    @Override
    public boolean add(final E item) {
        requireNonNull(item);
        final Node<E> newNode = new Node<>(item, tail, null);
        if (tail != null)
            tail.next = newNode;
        else
            head = newNode;
        tail = newNode;
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
    @Override
    public void add(final int index, final E item) {
        requireNonNull(item);
        rangeCheckForAdd(index);
        if(index == 0)
            addFirst(item);
        else if(index == size)
            add(item);
        else
            addToIndex(index, item);
    }

    /**
     * Appends all elements in the specified collection to the end of this list,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     */
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        requireNonNullCollection(c);
        if (c.isEmpty())
            return false;

        if (c instanceof CustomDoublyLinkedList<?> that) {
            @SuppressWarnings("unchecked")
            CustomDoublyLinkedList<E> other = (CustomDoublyLinkedList<E>) that;
            linkAfterTail(other.head, other.tail, other.size);
            return true;
        }
        size += update(size, c);
        return true;
    }

    /**
     * Inserts all elements in the specified collection into this list at the specified index,
     * in the order they are returned by the collection's iterator. Shifts the element currently
     * at that index (if any) and any subsequent elements to the right.
     *
     * @param index the index at which to insert the first element from the collection
     * @param c the collection containing elements to be added
     *
     * @return {@code true} if this list changed as a result of the call, {@code false} if the collection is empty
     *
     * @throws NullPointerException if the collection or any element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     */
    @Override
    public boolean addAll(final int index, final Collection<? extends E> c) {
        requireNonNullCollection(c);
        rangeCheckForAdd(index);
        if (c.isEmpty())
            return false;
        if (index == size && c instanceof CustomDoublyLinkedList<?> that) {
            @SuppressWarnings("unchecked")
            CustomDoublyLinkedList<E> other = (CustomDoublyLinkedList<E>) that;
            linkAfterTail(other.head, other.tail, other.size);
            return true;
        }
        size += update(index, c);
        return true;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item the element to be added to the head of the list
     *
     * @throws NullPointerException if the element is null
     */
    @Override
    public void addFirst(final E item) {
        requireNonNull(item);
        Node<E> node = new Node<>(item, null, head);
        if(head != null)
            head.previous = node;
        else
            tail = node;
        head = node;
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
    @Override
    public void addLast(final E item) {
        add(item);
    }

    /**
     * Removes all elements from this list, setting its size to zero and
     * resetting the head and tail to {@code null}.
     */
    @Override
    public void clear() {
        this.head = this.tail = null;
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
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public CustomDoublyLinkedList<E> clone() {
        CustomDoublyLinkedList<E> clone = new CustomDoublyLinkedList<>();
        for (Node<E> x = head; x != null; x = x.next)
            clone.add(x.data);
        return clone;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains at least
     * one element {@code e} such that {@code Objects.equals(item, e)}.
     *
     * @param o the element to search for (may be null)
     *
     * @return {@code true} if the element is present in the list, {@code false} otherwise
     */
    @Override
    public boolean contains(final Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns {@code true} if this list contains all elements in Collection.
     *
     * @param c collection to check for all values in CustomList
     *
     * @return {@code true} if this list contains all elements in collection
     *
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    @Override
    public boolean containsAll(final Collection<?> c) {
        requireNonNullCollection(c);
        Set<?> values = (c instanceof Set<?> s) ? s : new HashSet<>(c);
        for(Object o : values)
            if (!contains(o))
                return false;
        return true;
    }

    /**
     * Returns an iterator over the elements in this list in reverse sequential order.
     * The elements will be returned from last (tail) to first (head).
     * <p>
     * The returned iterator supports {@code remove()} but not {@code add()} or {@code set()}.
     * Calling {@code remove()} removes the last element returned by {@code next()}.
     *
     * @return an iterator over the elements in this list in reverse order
     * @see java.util.Deque#descendingIterator()
     */
    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<>() {
            private Node<E> node = tail;
            private Node<E> lastReturned = null;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (node == null)
                    throw new NoSuchElementException();
                lastReturned = node;
                E data = node.data;
                node = node.previous;
                return data;
            }

            @Override
            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException();
                CustomDoublyLinkedList.this.unlink(lastReturned);
                lastReturned = null;
            }
        };
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return {@code E} element at head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    public E element() {
        checkNotEmpty();
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
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof List<?> that))
            return false;
        if (size != that.size())
            return false;
        Iterator<E> itr1 = this.iterator();
        Iterator<?> itr2 = that.iterator();
        while (itr1.hasNext() && itr2.hasNext()) {
            E e1 = itr1.next();
            Object e2 = itr2.next();
            if (!Objects.equals(e1, e2))
                return false;
        }
        return !(itr1.hasNext() || itr2.hasNext());
    }

    /**
     * Returns the element at the specified index in this list. Uses bidirectional
     * traversal for efficiency, starting from the head or tail based on index proximity.
     *
     * @param index the index of the element to return
     *
     * @return {@code E} element at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public E get(final int index) {
        requireInRange(index);
        if(index == 0)
            return head.data;
        if(index == size - 1)
            return tail.data;
        return getNodeFromIndex(index).data;
    }

    /**
     * Gets but does not remove the first element of this list.
     *
     * @return {@code E} element at the start of the list.
     *
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getFirst() {
        checkNotEmpty();
        return head.data;
    }

    /**
     * Gets but does not remove the last element of this list.
     *
     * @return {@code E} element at the end of the list.
     *
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getLast() {
        checkNotEmpty();
        return tail.data;
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
     * @return {@code int} the hash code value for this list
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (Node<E> x = head; x != null; x = x.next)
            result = 31 * result + Objects.hashCode(x.data);
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if the element is not present.
     *
     * @param o the element to search for (may be null)
     *
     * @return {@code int} the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(final Object o) {
        int index = 0;
        for (Node<E> x = head; x != null; x = x.next, index++)
            if (Objects.equals(x.data, o))
                return index;
        return -1;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an {@code Iterator} over the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> node = head;
            private Node<E> lastReturned = null;

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
                CustomDoublyLinkedList.this.unlink(lastReturned);
                lastReturned = null;
            }
        };
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if the element is not present. Uses {@link Objects#equals(Object, Object)}
     * for comparison.
     *
     * @param o the element to search for (may be null)
     *
     * @return {@code int} the index of the last occurrence of the element, or -1 if not found
     */
    @Override
    public int lastIndexOf(final Object o) {
        int index = size - 1;
        for (Node<E> x = tail; x != null; x = x.previous, index--)
            if (Objects.equals(x.data, o))
                return index;
        return -1;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return {@code ListIterator} over the elements in this list in proper sequence
     */
    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @param index the index of the start of List Iterator
     *
     * @return {@code ListIterator} over the elements in this list in proper sequence
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    @Override
    public ListIterator<E> listIterator(final int index) {
        rangeCheckForAdd(index);
        return new CustomListIterator(index);
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
    @Override
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
    @Override
    public boolean offerFirst(final E item) {
        requireNonNull(item);
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
    @Override
    public boolean offerLast(final E item) {
        requireNonNull(item);
        addLast(item);
        return true;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return {@code E} element at the head of the list, or {@code null} if the list is empty
     */
    @Override
    public E peek() {
        return size == 0 ? null : head.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * This method is equivalent to {@link #peek()}.
     *
     * @return {@code E} element at the head of the list, or {@code null} if the list is empty
     */
    @Override
    public E peekFirst() {
        return peek();
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return {@code E} element at the end of the list, or {@code null} if the list is empty
     */
    @Override
    public E peekLast() {
        return size == 0 ? null : tail.data;
    }

    /**
     * Removes and returns the head (first element) of this list.
     *
     * @return {@code E} element at the head of the list, or {@code null} if the list is empty
     */
    @Override
    public E poll() {
        return size != 0 ? removeFirst() : null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()}.
     *
     * @return {@code E} element at the head of the list, or {@code null} if the list is empty
     */
    @Override
    public E pollFirst() {
        return poll();
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return {@code E} element at the end of the list, or {@code null} if the list is empty
     */
    @Override
    public E pollLast() {
        return size != 0 ? removeLast() : null;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return {@code E} element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E pop() {
        checkNotEmpty();
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
    @Override
    public void push(final E item) {
        addFirst(item);
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return {@code E} element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E remove() {
        return removeFirst();
    }

    /**
     * Removes the element at the specified index in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     *
     * @return {@code E} element that was removed
     *
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    @Override
    public E remove(final int index) {
        requireInRange(index);
        if (index == 0)
            return removeFirst();
        else if(index == size - 1)
            return removeLast();
        Node<E> node = getNodeFromIndex(index);
        return unlink(node);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     *
     * @param o the element to be removed (may be null)
     *
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(final Object o) {
        for(Node<E> node = head; node != null; node = node.next)
            if (Objects.equals(node.data, o)) {
                unlink(node);
                return true;
            }
        return false;
    }

    /**
     * Removes from this list all elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this list
     *
     * @return {@code true} if this list changed
     * @see Collection#contains(Object)
     */
    @Override
    public boolean removeAll(final Collection<?> c) {
        requireNonNullCollection(c);
        if (c.isEmpty())
            return false;
        final Set<?> remove = (c instanceof Set<?>) ? (Set<?>) c : new HashSet<>(c);
        boolean modified = false;
        for (Node<E> node = head, next; node != null; node = next) {
            next = node.next;
            if (remove.contains(node.data)) {
                unlink(node);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes and returns the head (first element) of this list.
     * This method is equivalent to {@link #poll()} but throws an exception if the list is empty.
     *
     * @return {@code E} element at the head of the list
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E removeFirst() {
        checkNotEmpty();
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
     * @param o the element to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    @Override
    public boolean removeFirstOccurrence(final Object o) {
        for(Node<E> node = head; node != null; node = node.next)
            if (Objects.equals(node.data, o)) {
                unlink(node);
                return true;
            }
        return false;
    }

    /**
     * Removes and returns the last element of this list.
     *
     * @return {@code E} the element that was removed
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E removeLast() {
        checkNotEmpty();
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
     * @param o the element to be removed (may be null)
     *
     * @return {@code true} if the element was found and removed, {@code false} otherwise
     */
    @Override
    public boolean removeLastOccurrence(final Object o) {
        for(Node<E> node = tail; node != null; node = node.previous)
            if (Objects.equals(node.data, o)) {
                unlink(node);
                return true;
            }
        return false;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     * In other words, removes from this list all of its elements that are not contained in {@code c}.
     *
     * @param c collection containing elements to be retained in this list
     *
     * @return {@code true} if this list changed as a result of the call
     *
     * @throws NullPointerException if {@code c} is null or contains null
     */
    @Override
    public boolean retainAll(final Collection<?> c) {
        requireNonNullCollection(c);
        if (c.isEmpty()) {
            boolean modified = !isEmpty();
            clear();
            return modified;
        }
        Set<?> retain = (c instanceof Set<?> s) ? s : new HashSet<>(c);
        boolean modified = false;
        for (Node<E> node = head, next; node != null; node = next) {
            next = node.next;
            if (retain != null && !retain.contains(node.data)) {
                unlink(node);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Replaces the element at the specified index in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param item the new element to set at the specified index
     *
     * @return {@code E} previous element at the specified index
     *
     * @throws NullPointerException if the element is null
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    @Override
    public E set(final int index, final E item) {
        requireInRange(index);
        requireNonNull(item);
        if(index == 0) {
            E previousValue = head.data;
            head.data = item;
            return previousValue;
        } else if(index == size - 1) {
            E previousValue = tail.data;
            tail.data = item;
            return previousValue;
        }
        return updateIndex(index, item);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return {@code int} the number of elements in this list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns a new list containing the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.
     * Note: The returned list is a copy, not a view backed by the original.
     *
     * @param fromIndex index of the first element (inclusive)
     * @param toIndex index after the last element (exclusive)
     *
     * @return a new {@code CustomDoublyLinkedList} containing the specified range of elements
     *
     * @throws IndexOutOfBoundsException if {@code fromIndex < 0}, {@code toIndex > size()} or {@code fromIndex > toIndex}
     */
    @Override
    public List<E> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        if(fromIndex == toIndex)
            return new CustomDoublyLinkedList<>();
        CustomDoublyLinkedList<E> result = new CustomDoublyLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++)
            result.add(get(i));
        return result;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence
     * (from head to tail).
     *
     * @return {@code Object[]} array containing the elements of this list
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for(Node<E> node = head; node != null; node = node.next)
            array[index++] = node.data;
        return array;
    }

    /**
     * Returns an array containing all elements in this list in proper sequence,
     * using the specified array if it is large enough.
     *
     * @param a the array into which the elements are to be stored, if it is large enough
     *
     * @return {@code <T> T[]} array containing the elements of this list
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int index = 0;
        for (Node<E> node = head; node != null; node = node.next)
            a[index++] = (T) node.data;
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this list.
     * The string representation consists of the elements of the list in order,
     * enclosed in square braces ({@code "[]"}). Adjacent elements are separated
     * by a comma and a space ({@code ", "]). If the list is empty, returns
     * {@code "[]"}.
     * @return a {@code String}  representation of this list
     */
    @Override
    public String toString() {
        if(size == 0)
            return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> node = head;
        while (node != null) {
            if(stringBuilder.length() > 1)
                stringBuilder.append(", ");
            stringBuilder.append(node.data);
            node = node.next;
        }
        return stringBuilder.append("]").toString();
    }

    /**
     * A node in the doubly-linked list, containing an element and references to the previous and next nodes.
     */
    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private void addToIndex(int index, E item) {
        Node<E> successor = getNodeFromIndex(index);
        Node<E> predecessor = successor.previous;
        Node<E> newNode = new Node<>(item, predecessor, successor);
        if (predecessor != null)
            predecessor.next = newNode;
        else
            head = newNode;
        successor.previous = newNode;
        size++;
    }

    private void checkNotEmpty() {
        if(size == 0)
            throw new NoSuchElementException();
    }

    private Node<E> getFromHead(final int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            if (node == null)
                throw new IllegalStateException();
            node = node.next;
        }
        return node;
    }

    private Node<E> getFromTail(final int index) {
        Node<E> node = tail;
        for (int i = size - 1; i > index; i--)
            node = node.previous;
        return node;
    }

    private Node<E> getNodeFromIndex(int fromIndex) {
        return (fromIndex < (size >> 1)) ? getFromHead(fromIndex) : getFromTail(fromIndex);
    }

    private void insertCollection(int index, Node<E> first, Node<E> last) {
        Node<E> next = getNodeFromIndex(index);
        Node<E> previous = next.previous;
        if (previous != null)
            previous.next = first;
        else
            head = first;
        next.previous = last;
    }

    private void linkAfterTail(Node<E> first, Node<E> last, int count) {
        if (tail != null) {
            tail.next = first;
            first.previous = tail;
        } else {
            head = first;
        }
        tail = last;
        size += count;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void requireInRange(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void requireNonNull(E item) {
        if(item == null)
            throw new NullPointerException("Null elements not supported");
    }

    private void requireNonNullCollection(Collection<?> c) {
        if(c == null)
            throw new NullPointerException("Null collection not supported");
    }

    private E unlink(final Node<E> node) {
        if (node == null)
            throw new IllegalStateException("List structure corrupted");
        E data = node.data;
        Node<E> prev = node.previous;
        Node<E> next = node.next;
        if (prev == null)
            head = next;
        else
            prev.next = next;
        if (next == null)
            tail = prev;
        else
            next.previous = prev;
        size--;
        return data;
    }

    private int update(int index, Collection<? extends E> c) {
        Node<E> first = null;
        Node<E> last = null;
        int count = 0;
        for (E value : c) {
            requireNonNull(value);
            Node<E> node = new Node<>(value, last, null);
            if (first == null)
                first = node;
            else
                last.next = node;
            last = node;
            count++;
        }
        updateList(index, first, last);
        return count;
    }

    private E updateForward(final int index, final E item) {
        requireNonNull(item);
        Node<E> node = head;
        for(int i = 0; i < index; i++)
            node = node.next;
        E previous = node.data;
        node.data = item;
        return previous;
    }

    private E updateIndex(final int index, final E item) {
        return index > size / 2 ? updateReverse(index, item) : updateForward(index, item);
    }

    private void updateList(int index, Node<E> first, Node<E> last) {
        if (index == 0) {
            if (head != null)
                head.previous = last;
            last.next = head;
            head = first;
            if (size == 0)
                tail = last;
        } else if (index == size) {
            if(tail != null)
                tail.next = first;
            first.previous = tail;
            tail = last;
        } else
            insertCollection(index, first, last);
    }

    private E updateReverse(final int index, final E item) {
        requireNonNull(item);
        Node<E> node = tail;
        for(int i = size - 1; i > index; i--)
            node = node.previous;
        E previous = node.data;
        node.data = item;
        return previous;
    }

    private class CustomListIterator implements ListIterator<E> {
        private Node<E> nextNode;
        private Node<E> lastReturned = null;
        private int nextIndex;

        CustomListIterator(int index) {
            rangeCheckForAdd(index);
            this.nextIndex = index;
            this.nextNode = (index == size) ? null : getFromHead(index);
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = nextNode;
            E data = nextNode.data;
            nextNode = nextNode.next;
            nextIndex++;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            if (nextNode == null)
                nextNode = tail;
            else
                nextNode = nextNode.previous;
            lastReturned = nextNode;
            nextIndex--;
            return nextNode.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            Node<E> prev = lastReturned.previous;
            Node<E> next = lastReturned.next;
            if (prev != null)
                prev.next = next;
            else
                head = next;

            if (next != null)
                next.previous = prev;
            else
                tail = prev;
            size--;
            if (nextNode == lastReturned)
                nextNode = next;
            lastReturned = null;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            requireNonNull(e);
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
            requireNonNull(e);
            if (nextNode == null) {
                Node<E> newNode; newNode = new Node<>(e, tail, null);
                if (tail == null)
                    head = tail = newNode;
                else
                    tail.next = newNode;
            } else {
                Node<E> previous = nextNode.previous;
                Node<E> newNode; newNode = new Node<>(e, previous, nextNode);
                if (previous != null)
                    previous.next = newNode;
                else
                    head = newNode;
                nextNode.previous = newNode;
            }
            size++;
            nextIndex++;
            lastReturned = null;
        }
    }
}
