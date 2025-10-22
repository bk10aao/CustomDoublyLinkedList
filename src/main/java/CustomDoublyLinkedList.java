import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomDoublyLinkedList<E> implements CustomDoublyLinkedListInterface<E> {

    private Node head;
    private Node tail;

    private int size = 0;

    public CustomDoublyLinkedList() { }

    public CustomDoublyLinkedList(final Collection<E> items) {
        if(items == null)
            throw new NullPointerException("Null collection not supported");
        for (E item : items)
            add(item);
    }

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

    public void add(final int position, final E data) {
        if (data == null)
            throw new NullPointerException();
        if(position > size || position < 0)
            throw new IndexOutOfBoundsException();
        if(position == 0)
            addFirst(data);
        else if(position == size)
            add(data);
        else
            addToIndex(data, position > size / 2 ? getNodeByIndexFromTail(position) : getFromHead(position));
    }

    public boolean addAll(final Collection<E> collection) {
        if(collection == null)
            throw new NullPointerException();
        int startSize = size;
        collection.forEach(this::add);
        return startSize != size;
    }

    public boolean addAll(final int index, final Collection<E> collection) {
        if(collection == null)
            throw new NullPointerException("Null collection not supported");
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(collection.isEmpty())
            return false;
        Node first = null;
        Node last = null;
        for(E e : collection) {
            if(e == null)
                throw new NullPointerException();
            Node newNode = new Node(e);
            if(first == null)
                first = newNode;
            else {
                last.next = newNode;
                newNode.previous = last;
            }
            last = newNode;
        }
        if(index == 0) {
            last.next = head;
            if(head != null)
                head.previous = last;
            head = first;
            if(size == 0)
                tail = last;
        } else if(index == size) {
            tail.next = first;
            first.previous = tail;
            tail = last;
        } else {
            Node node = index > size / 2 ? getNodeByIndexFromTail(index) : getFromHead(index);
            first.previous = node.previous;
            if(node.previous != null)
                node.previous.next = first;
            last.next = node;
            node.previous = last;
        }
        size += collection.size();
        return true;
    }

    public void addFirst(final E data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public void addLast(final E data) {
        if(data == null)
            throw new NullPointerException();
        Node node = new Node(data);
        if (tail == null)
            head = node;
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public CustomDoublyLinkedList<E> clone() {
        CustomDoublyLinkedList<E> clone = new CustomDoublyLinkedList<>();
        for (Node x = head; x != null; x = x.next)
            clone.add(x.data);
        return clone;
    }

    public boolean contains(final E item) {
        if(item == null)
            throw new NullPointerException();
        for(Node node = head; node != null; node = node.next)
            if (Objects.equals(item, node.data))
                return true;
        return false;
    }

    public E element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomDoublyLinkedList<?> that))
            return false;
        if (size != that.size)
            return false;
        Iterator<E> i1 = this.iterator();
        Iterator<?> i2 = that.iterator();
        while(i1.hasNext() && i2.hasNext())
            if (!Objects.equals(i1.next(), i2.next()))
                return false;
        return !i1.hasNext() && !i2.hasNext();
    }

    public E get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            return head.data;
        if(index == size - 1)
            return tail.data;
        return (index > size / 2) ? getFromTail(index) : getFromHead(index).data;
    }

    public int hashCode() {
        int result = 1;
        for (Node x = head; x != null; x = x.next)
            result = 31 * result + x.data.hashCode();
        return result;
    }

    public int indexOf(final E item) {
        int index = 0;
        for (Node x = head; x != null; x = x.next, index++)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

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

    public int lastIndexOf(final E item) {
        int index = size - 1;
        for (Node x = tail; x != null; x = x.previous, index--)
            if (Objects.equals(x.data, item))
                return index;
        return -1;
    }

    public boolean offer(final E item) {
        return add(item);
    }

    public boolean offerFirst(final E item) {
        if (item == null)
            throw new NullPointerException();
        addFirst(item);
        return true;
    }

    public boolean offerLast(final E item) {
        if (item == null)
            throw new NullPointerException();
        addLast(item);
        return true;
    }

    public E peekFirst() {
        return peek();
    }

    public E peek() {
        return size == 0 ? null : head.data;
    }

    public E peekLast() {
        return size == 0 ? null : tail.data;
    }

    public E poll() {
        return size != 0 ? removeFirst() : null;
    }

    public E pollFirst() {
        return poll();
    }

    public E pollLast() {
        return size != 0 ? removeLast() : null;
    }

    public E pop() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    public void push(final E item) {
        addFirst(item);
    }

    public E remove() {
        return removeFirst();
    }

    public E remove(final E item) {
        if(item == null)
            throw new NullPointerException();
        for(Node node = head; node != null; node = node.next)
            if (Objects.equals(node.data, item))
                return getFromIndex(node);
        return null;
    }

    public E remove(final int position) {
        if (position < 0 || position >= size)
            throw new IndexOutOfBoundsException();
        if (position == 0)
            return removeFirst();
        else if(position == size - 1)
            return removeLast();
        Node node = position > size / 2 ? getNodeByIndexFromTail(position) : getFromHead(position);
        return getFromIndex(node);
    }

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

    public boolean removeFirstOccurrence(final E item) {
        if(item == null)
            return false;
        for(Node node = head; node != null; node = node.next)
            if (Objects.equals(node.data, item))
                return getFromIndex(node) != null;
        return false;
    }

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

    public boolean removeLastOccurrence(final E item) {
        if(item == null)
            return false;
        for(Node node = tail; node != null; node = node.previous)
            if (Objects.equals(node.data, item))
                return getFromIndex(node) != null;
        return false;
    }

    public E set(final int index, final E item) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            E previousValue = head.data;
            head.data = item;
            return previousValue;
        } else
            return updateIndex(index, item);
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for(Node node = head; node != null; node = node.next)
            array[index++] = node.data;
        return (E[])array;
    }

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

    private void addToIndex(final E data, final Node newNode) {
        if (data == null)
            throw new NullPointerException();
        Node node = new Node(data);
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

    private class Node {
        private E data;
        private Node previous = null;
        private Node next = null;

        public Node(E data) {
            this.data = data;
        }
    }
}
