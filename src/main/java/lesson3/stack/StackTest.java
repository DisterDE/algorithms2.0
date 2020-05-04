package lesson3.stack;

public class StackTest {
    private static final int STACK_SIZE = 5;

    public static void main(String[] args) {
        MyStack<Integer> numStack = new MyStack<>(STACK_SIZE);
        for (int i = 0; i < STACK_SIZE; i++) {
            numStack.push(i + 1);
        }

        System.out.println(numStack);

        System.out.println("Peek: " + numStack.peek());

        System.out.println("Pop: " + numStack.pop());
        System.out.println("Pop: " + numStack.pop());

        System.out.println(numStack);
    }
}
