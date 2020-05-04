package lesson2.array;

public final class MyArrayUtils {
    private MyArrayUtils() {
    }

    public static <E extends Comparable<E>> void sortBubble(MyArray<E> elements) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elements.get(j).compareTo(elements.get(j + 1)) > 0) {
                    swapElements(elements, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sortSelect(MyArray<E> elements) {
        for (int i = 0; i < elements.size(); i++) {
            E minimum = elements.get(i);
            int minIndex = i;
            for (int j = i; j < elements.size(); j++) {
                E element = elements.get(j);
                if (element.compareTo(minimum) < 0) {
                    minimum = element;
                    minIndex = j;
                }
            }
            swapElements(elements, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void quickSort(MyArray<E> elements, int start, int finish) {
        if (elements.size() == 0) {
            return;
        }

        int mid = start + (finish - start) / 2;
        E pivot = elements.get(mid);

        int left = start;
        int right = finish;

        while (left <= right) {
            while (elements.get(left).compareTo(pivot) < 0) {
                left++;
            }

            while (elements.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swapElements(elements, left, right);
                left++;
                right--;
            }

            if (start < right) {
                quickSort(elements, start, right);
            }

            if (left < finish) {
                quickSort(elements, left, finish);
            }
        }
    }

    private static <E extends Comparable<E>> void swapElements(MyArray<E> elements, int index1, int index2) {
        if ((index1 == index2) || (index1 < 0 || index2 < 0)
                || (index1 >= elements.size() || index2 >= elements.size())) {
            return;
        }
        E temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }
}
