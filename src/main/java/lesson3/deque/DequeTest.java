package lesson3.deque;

public class DequeTest {
    private static final int DEQUE_SIZE = 6;

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>(DEQUE_SIZE);

        for (int i = 0; i < DEQUE_SIZE / 2; i++) {
            deque.addFirst(i + 1);
            deque.addLast(DEQUE_SIZE - i);
        }

        System.out.println(deque);

        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());

        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("Remove first: " + deque.removeFirst());

        System.out.println(deque);

        System.out.println("Add last: 3");
        deque.addLast(3);
        System.out.println(deque);

        System.out.println("Add first: 55");
        deque.addFirst(55);
        System.out.println(deque);
    }
}
