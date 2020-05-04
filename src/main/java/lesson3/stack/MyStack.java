package lesson3.stack;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class MyStack<E> implements Iterable<E> {
    private final Object[] storage;
    private int size;

    public MyStack(int size) {
        this.storage = new Object[size];
        this.size = 0;
    }

    public boolean push(E item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        storage[size++] = item;
        return true;
    }

    public E pop() {
        E temp = (E) storage[--size];
        storage[size] = null;
        return temp;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) storage[size - 1];
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
        MyStack<?> myStack = (MyStack<?>) o;
        return size == myStack.size &&
                Arrays.equals(storage, myStack.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================");
        sb.append("\n");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(storage[i]);
            sb.append("\n");
        }
        sb.append("=====================");
        return sb.toString();
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
