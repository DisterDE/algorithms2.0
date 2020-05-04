package lesson3.queue;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class MyQueue<E> {
    private static final int DEFAULT_FRONT = 0;
    private static final int DEFAULT_BACK = -1;

    private final Object[] storage;
    private int size;
    private int front;
    private int back;

    public MyQueue(int size) {
        this.storage = new Object[size];
        this.front = DEFAULT_FRONT;
        this.back = DEFAULT_BACK;
        this.size = 0;
    }

    public boolean insert(E item) {
        if (isFull()) {
            throw new StackOverflowError("Queue is full");
        }

        if (back == storage.length - 1) {
            back = DEFAULT_BACK;
        }

        storage[++back] = item;
        size++;
        return true;
    }

    public E remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (front == storage.length) {
            front = DEFAULT_FRONT;
        }

        E result = (E) storage[front];
        storage[front++] = null;
        size--;
        return result;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (E) storage[front];
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
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return size == myQueue.size &&
                front == myQueue.front &&
                back == myQueue.back &&
                Arrays.equals(storage, myQueue.storage);
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
        int currentFront = front;
        for (int i = 0; i < size; i++) {
            if (currentFront == storage.length) {
                currentFront = DEFAULT_FRONT;
            }

            sb.append(storage[currentFront++]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
