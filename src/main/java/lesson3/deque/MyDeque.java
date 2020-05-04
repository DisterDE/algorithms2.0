package lesson3.deque;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class MyDeque<E> {
    private static final int DEFAULT_FRONT = 0;
    private static final int DEFAULT_BACK = -1;

    private final Object[] storage;
    private int size;
    private int front;
    private int back;

    public MyDeque(int size) {
        this.storage = new Object[size];
        this.front = DEFAULT_FRONT;
        this.back = DEFAULT_BACK;
        this.size = 0;
    }

    public boolean addFirst(E item) {
        if (isFull()) {
            throw new StackOverflowError("Deque is full");
        }

        if (front == 0) {
            front = storage.length;
        }

        storage[--front] = item;
        size++;
        return true;
    }

    public boolean addLast(E item) {
        if (isFull()) {
            throw new StackOverflowError("Deque is full");
        }

        if (back == storage.length - 1) {
            back = DEFAULT_BACK;
        }

        storage[++back] = item;
        size++;
        return true;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E result = (E) storage[front];
        storage[front++] = null;
        size--;

        if (front == storage.length) {
            front = DEFAULT_FRONT;
        }

        return result;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (back == DEFAULT_BACK) {
            back = storage.length - 1;
        }

        E result = (E) storage[back];
        storage[back--] = null;
        size--;

        return result;
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) storage[front];
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (back == DEFAULT_BACK) {
            return (E) storage[storage.length - 1];
        }
        return (E) storage[back];
    }

    public boolean isFull() {
        return size == storage.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDeque<?> myDeque = (MyDeque<?>) o;
        return size == myDeque.size &&
                front == myDeque.front &&
                back == myDeque.back &&
                Arrays.equals(storage, myDeque.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, front, back);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int currentPosition = front;
        for (int i = 0; i < size; i++) {
            if (currentPosition == storage.length) {
                currentPosition = 0;
            }
            sb.append(storage[currentPosition++]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
