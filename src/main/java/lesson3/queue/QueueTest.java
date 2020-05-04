package lesson3.queue;

public class QueueTest {
    private static final int QUEUE_SIZE = 5;

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>(QUEUE_SIZE);

        for (int i = 0; i < QUEUE_SIZE; i++) {
            System.out.println("Added: " + (i + 1));
            queue.insert(i + 1);
        }

        System.out.println(queue);

        System.out.println("Peek: " + queue.peek());

        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());

        System.out.println(queue);
        System.out.println("Peek: " + queue.peek());

        System.out.println("Added: 6");
        queue.insert(6);
        System.out.println(queue);
    }
}
