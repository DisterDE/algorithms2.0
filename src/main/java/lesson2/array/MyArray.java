package lesson2.array;

import java.util.Arrays;
import java.util.Objects;

public class MyArray<E extends Comparable<E>> {
    private static final double DEFAULT_EXTEND_COUNT = 0.75;
    private static final int DEFAULT_SIZE = 10;

    private final double extendCount;
    private Object[] storage;
    private int size;

    public MyArray() {
        this(DEFAULT_SIZE, DEFAULT_EXTEND_COUNT);
    }

    public MyArray(int initCapacity) {
        this(initCapacity, DEFAULT_EXTEND_COUNT);
    }

    public MyArray(double extendCount) {
        this(DEFAULT_SIZE, extendCount);
    }

    public MyArray(int initCapacity, double extendCount) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("Init capacity must be positive number!");
        }
        if (extendCount > 1 || extendCount < 0) {
            throw new IllegalArgumentException("Incorrect extend count! It should be more than 0 and less than 1.");
        }
        this.storage = new Object[initCapacity];
        this.extendCount = extendCount;
        this.size = 0;
    }

    public boolean add(E element) {
        return add(size, element);
    }

    public boolean add(int index, E element) {
        checkCapacity();

        if (index == size) {
            storage[size++] = element;
            return true;
        }

        try {
            for (int i = size; i > index; i--) {
                storage[i] = storage[i - 1];
            }
            storage[index] = element;
            size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " doesn't exist");
        }
        return (E) storage[index];
    }

    public boolean set(int index, E element) {
        if (index < 0 || index >= size) {
            return false;
        }
        storage[index] = element;
        return true;
    }

    public int findFirst(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(storage[i])) {
                return i;
            }
        }
        return -1;
    }

    public int findLast(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(storage[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        if (size == 0) {
            return false;
        }

        if (index >= size) {
            return false;
        }

        try {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            size--;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeFirst(E element) {
        int index = findFirst(element);

        if (index == -1) {
            return false;
        }

        return remove(index);
    }

    public boolean removeLast(E element) {
        int index = findLast(element);

        if (index == -1) {
            return false;
        }

        return remove(index);
    }

    public int size() {
        return size;
    }

    private void checkCapacity() {
        if (size < storage.length * extendCount) {
            return;
        }
        Object[] newStorage = new Object[(int) (storage.length * 1.5)];
        System.arraycopy(storage, 0, newStorage, 0, size);
        storage = newStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray<?> myArray = (MyArray<?>) o;
        return size == myArray.size &&
                Arrays.equals(storage, myArray.storage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(storage[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
