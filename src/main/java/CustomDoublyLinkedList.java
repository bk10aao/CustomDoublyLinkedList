import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomDoublyLinkedList<E> implements CustomDoublyLinkedListInterface<E> {

    private Node head;
    private Node tail;

    private int size = 0;

    public CustomDoublyLinkedList() { }

    public CustomDoublyLinkedList(final Collection<E> items) {
        if(items == null)
            throw new NullPointerException("Null collection not supported");
        for (E item : items)
            addLast(item);
    }

    public boolean add(final E item) {
        Node temp = new Node(item);
        if (tail == null)
            head = temp;
        else {
            tail.next = temp;
            temp.previous = tail;
        }
        tail = temp;
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
            Node current = index > size / 2 ? getNodeByIndexFromTail(index) : getFromHead(index);
            first.previous = current.previous;
            if(current.previous != null)
                current.previous.next = first;
            last.next = current;
            current.previous = last;
        }
        size += collection.size();
        return true;
    }

    public void addFirst(final E data) {
        Node temp = new Node(data);
        if(head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
        size++;
    }

    public void addLast(final E data) {
        add(data);
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
        return indexOf(item) != -1;
    }

    public E element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomDoublyLinkedList<?> that)) return false;
        if (size != that.size) return false;
        Node thisNode = head;
        Node thatNode = (Node) that.head;
        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.data, thatNode.data)) return false;
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        return thisNode == null && thatNode == null;
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
        return head.data.equals(item);
    }

    public boolean offerLast(final E item) {
        if (item == null)
            throw new NullPointerException();
        addLast(item);
        return tail.data.equals(item);
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
        return contains(item) ? remove(indexOf(item)) : null;
    }

    public E remove(final int position) {
        if (position < 0 || position >= size)
            throw new IndexOutOfBoundsException();
        if (position == 0)
            return removeFirst();
        else if(position == size - 1)
            return removeLast();
        Node current = position > size / 2 ? getNodeByIndexFromTail(position) : getFromHead(position);
        return getFromIndex(current);
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
        return item != null && size != 0 && contains(item) && remove(indexOf(item)) != null;
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
        return item != null && size != 0 && contains(item) && remove(lastIndexOf(item)) != null;
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

    public E[] toArray() {
        if(head != null) {
            Object[] array = new Object[size];
            int insertIndex = 0;
            Node currentNode = head;
            while(currentNode.next != null) {
                array[insertIndex++] = currentNode.data;
                currentNode = currentNode.next;
            }
            array[insertIndex] = currentNode.data;
            return (E[]) array;
        }
        return null;
    }

    @Override
    public String toString() {
        if(size == 0)
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data).append(", ");
            temp = temp.next;
        }
        return stringBuilder.replace(stringBuilder.lastIndexOf(", "), stringBuilder.length(), " }").toString();
    }

    private void addToIndex(final E data, final Node current) {
        if (data == null)
            throw new NullPointerException();
        Node temp = new Node(data);
        temp.next = current;
        temp.previous = current.previous;
        if (current.previous != null)
            current.previous.next = temp;
        current.previous = temp;
        size++;
    }

    private Node getNodeByIndexFromTail(final int position) {
        Node current = tail;
        for(int i = size - 1; i > position; i--) {
            if(current == null)
                throw new IllegalStateException();
            current = current.previous;
        }
        return current;
    }

    private E getFromIndex(final Node current) {
        if (current == null)
            throw new IllegalStateException("List structure corrupted");
        E data = current.data;
        current.previous.next = current.next;
        if (current.next != null)
            current.next.previous = current.previous;
        else
            tail = current.previous;
        size--;
        return data;
    }

    private Node getFromHead(final int index) {
        Node current = head.next;
        for (int i = 0; i < index - 1; i++) {
            if (current == null)
                throw new IllegalStateException();
            current = current.next;
        }
        return current;
    }

    private E getFromTail(final int index) {
        Node currentTail = tail;
        for (int i = size - 1; i > index; i--)
            currentTail = currentTail.previous;
        return currentTail.data;
    }

    private E updateIndex(final int index, final E item) {
        return index > size / 2 ? updateReverse(index, item) : updateForward(index, item);
    }

    private E updateForward(final int index, final E item) {
        if(item == null)
            throw new NullPointerException();

        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current == null)
                throw new IllegalStateException();
            current = current.next;
        }
        E previous = current.data;
        current.data = item;
        return previous;
    }

    private E updateReverse(final int index, final E item) {
        if(item == null)
            throw new NullPointerException();
        Node current = tail;
        for(int i = size - 1; i > index; i--) {
            if(current == null)
                throw new IllegalStateException();
            current = current.previous;
        }
        E previous = current.data;
        current.data = item;
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
