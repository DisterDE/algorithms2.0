package lesson2.myarray;

import java.util.Random;

public class MyArrayTest {
    private static final int ARRAY_SIZE = 1_000_000;
    private static final Random RND = new Random();

    public static void main(String[] args) {
        MyArray<Integer> numbers = new MyArray<>((int) (ARRAY_SIZE * 1.5));

        fillRandomNumbers(numbers);
        long start = System.currentTimeMillis();
        MyArrayUtils.sortBubble(numbers);
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - start));

        fillRandomNumbers(numbers);
        start = System.currentTimeMillis();
        MyArrayUtils.sortSelect(numbers);
        System.out.println("Selection sort: " + (System.currentTimeMillis() - start));

        fillRandomNumbers(numbers);
        start = System.currentTimeMillis();
        MyArrayUtils.quickSort(numbers, 0, numbers.size() - 1);
        System.out.println("Quick sort: " + (System.currentTimeMillis() - start));
    }

    private static void fillRandomNumbers(MyArray<Integer> numbers) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers.add(RND.nextInt());
        }
    }
}
