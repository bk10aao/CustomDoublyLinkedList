import java.util.Collection;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class CustomDoublyLinkedList<T> implements CustomDoublyLinkedListInterface<T> {

    private Node head;
    private Node tail;

    private int size = 0;

    public CustomDoublyLinkedList() { }

    public CustomDoublyLinkedList(final Collection<T> items) {
        if(items == null)
            throw new NullPointerException("Null collection not supported");
        this.addAll(items);
    }

    public boolean add(final T item) {
        addLast(item);
        return true;
    }

    public void add(final int position, final T data) {
        if(position > size || position < 0)
            throw new IndexOutOfBoundsException();
        if(position == 0)
            addFirst(data);
        else if(position == size)
            addLast(data);
        else {
            Node current = position > size / 2 ? getNodeByIndexFromTail(position) :  getNodeByIndexFromHead(position);
            addToIndex(data, current);
        }
    }

    public boolean addAll(final Collection<T> collection) {
        if(collection == null)
            throw new NullPointerException();
        int startSize = size;
        collection.forEach(this::add);
        return startSize != size;
    }

    public boolean addAll(final int index, final Collection<T> collection) {
        if(collection == null)
            throw new NullPointerException("Null collection not supported");
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        int startSize = size;
        int insertIndex = 0;
        Node currentNode = head;
        while(currentNode.next != null) {
            if(insertIndex == index) {
                for (T item : collection)
                    add(insertIndex++, item);
                break;
            }
            insertIndex++;
            currentNode = currentNode.next;
        }
        return startSize != size;
    }

    public void addFirst(final T data) {
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

    public void addLast(final T data) {
        Node temp = new Node(data);
        if (tail == null)
            head = temp;
        else {
            tail.next = temp;
            temp.previous = tail;
        }
        tail = temp;
        size++;
    }

    public CustomDoublyLinkedList<T> clone() {
        CustomDoublyLinkedList<T> clone;
        try {
            clone = (CustomDoublyLinkedList<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        for (Node x = head; x != null; x = x.next)
            clone.add(x.data);
        return clone;
    }

    public boolean contains(final T item) {
        if(item == null)
            throw new NullPointerException();
        return indexOf(item) > -1;
    }

    public T element() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass())
            return false;
        CustomDoublyLinkedList<?> that = (CustomDoublyLinkedList<?>) o;
        T[] firstArray = this.toArray();
        T[] secondArray = (T[]) ((CustomDoublyLinkedList<?>) o).toArray();
        for(int i = 0; i < firstArray.length; i++)
            if (!firstArray[i].equals(secondArray[i]))
                return false;
        return size == that.size;
    }

    public T get(final int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            return head.data;
        if(index == size - 1)
            return tail.data;
        return (index > size / 2) ? getFromTail(index) : getFromHead(index);
    }

    public int indexOf(final T item) {
        int index = 0;
        for (Node x = head; x != null; x = x.next, index++)
            if (x.data == item)
                return index;
        return -1;
    }

    public int lastIndexOf(final T item) {
        int index = size - 1;
        for (Node x = tail; x != null; x = x.previous, index--)
            if (x.data == item)
                return index;
        return -1;
    }

    public boolean offer(final T item) {
        return add(item);
    }

    public boolean offerFirst(final T item) {
        addFirst(item);
        return head.data == item;
    }

    public boolean offerLast(final T item) {
        addLast(item);
        return peekLast().equals(item);
    }

    public T peekFirst() {
        return size != 0 ? peek() : null;
    }

    public T peek() {
        return head.data;
    }

    public T peekLast() {
        if(size == 0)
            return null;
        else if(size == 1)
            return head.data;
        return tail.data;
    }

    public T poll() {
        return size != 0 ? removeFirst() : null;
    }

    public T pollFirst() {
        return poll();
    }

    public T pollLast() {
        return size != 0 ? remove(size - 1) : null;
    }

    public T pop() {
        if(size == 0)
            throw new NoSuchElementException();
        return poll();
    }

    public void push(final T item) {
        addFirst(item);
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public T remove() {
        return removeFirst();
    }

    public T remove(final T item) {
        return contains(item) ? remove(indexOf(item)) : null;
    }

    public T remove(final int position) {
        if (position >= size || position < 0)
            throw new IndexOutOfBoundsException();
        if (head == null)
            return null;
        else if (position == 0)
            return removeFirst();
        else if(position == size - 1)
            return removeLast();
        else {
            Node current = head;
            int count = 0;
            while (current != null && count++ != position)
                current = current.next;
            assert current != null;
            return getFromIndex(current);
        }
    }

    public T removeFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        if (head == null)
            return null;
        T previous = head.data;
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

    public boolean removeFirstOccurrence(final T item) {
        if(item == null || size == 0)
            return false;
        return contains(item) && remove(indexOf(item)) != null;
    }

    public T removeLast() {
        if(size == 0)
            throw new NoSuchElementException();
        if (tail == null)
            return null;
        if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        T data = tail.data;
        tail = tail.previous;
        tail.next = null;
        size--;
        return data;
    }

    public boolean removeLastOccurrence(final T item) {
        if(item == null || size == 0)
            return false;
        return contains(item) && remove(lastIndexOf(item)) != null;
    }

    public T set(final int index, final T item) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0) {
            T previousValue = head.data;
            head.data = item;
            return previousValue;
        } else
            return updateIndex(index, item);
    }

    public int size() {
        return this.size;
    }

    public T[] toArray() {
        if(head != null) {
            Object[] array = new Object[size];
            int insertIndex = 0;
            Node currentNode = head;
            while(currentNode.next != null) {
                array[insertIndex++] = currentNode.data;
                currentNode = currentNode.next;
            }
            array[insertIndex] = currentNode.data;
            return (T[]) array;
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

    private void addToIndex(final T data, final Node current) {
        Node temp = new Node(data);
        temp.next = current;
        temp.previous = current.previous;
        assert current.previous != null;
        current.previous.next = temp;
        current.previous = temp;
        size++;
    }

    private T getFromHead(final int index) {
        Node current = head.next;
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        return current.data;
    }

    private Node getNodeByIndexFromHead(final int position) {
        Node current = head;
        int currentPosition = 1;
        while (current.next != null && currentPosition++ <= position)
            current = current.next;
        return current;
    }

    private Node getNodeByIndexFromTail(final int position) {
        Node current;
        current = tail;
        int currentPosition = size - 1;
        while(current.previous != null && currentPosition-- > position)
            current = current.previous;
        return current;
    }

    private T getFromIndex(final Node current) {
        assert current != null;
        T data = current.data;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.previous = null;
        current.next = null;
        size--;
        return data;
    }

    private T getFromTail(final int index) {
        Node currentTail = tail;
        for (int i = size - 1; i > index; i--)
            currentTail = currentTail.previous;
        return currentTail.data;
    }

    private T updateIndex(final int index, final T item) {
        return index > size / 2 ? updateReverse(index, item) : updateForward(index, item);
    }

    private T updateForward(final int index, final T item) {
        T previousValue;
        int currentIndex = 0;
        Node currentHead = head;
        while (currentHead.next != null) {
            if (currentIndex == index) {
                previousValue = currentHead.data;
                currentHead.data = item;
                return previousValue;
            }
            currentHead = currentHead.next;
            currentIndex++;
        }
        return null;
    }

    private T updateReverse(final int index, final T item) {
        int currentIndex = size - 1;
        Node currentTail = tail;
        while (tail.previous != null) {
            if (currentIndex == index) {
                T previousValue = currentTail.data;
                currentTail.data = item;
                return previousValue;
            }
            currentTail = currentTail.previous;
            currentIndex--;
        }
        return null;
    }

    private class Node {
        private T data;
        private Node previous = null;
        private Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }
}
