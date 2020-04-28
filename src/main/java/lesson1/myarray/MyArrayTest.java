package lesson1.myarray;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray<Integer> numbers = new MyArray<>();
        numbers.add(0, 5);
        numbers.add(0, 4);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(1);
        numbers.add(0);
        System.out.println(numbers);

        numbers.add(2, 3);
        System.out.println(numbers);

        numbers.removeFirst(1);
        System.out.println(numbers);

        numbers.removeLast(1);
        System.out.println(numbers);

//        MyArrayUtils.sortBubble(numbers);
//        MyArrayUtils.sortSelect(numbers);
        MyArrayUtils.quickSort(numbers, 0, numbers.size() - 1);
        System.out.println(numbers);

        System.out.println("first: " + numbers.get(0));

        System.out.println("size: " + numbers.size());
    }
}
