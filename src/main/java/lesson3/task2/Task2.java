package lesson3.task2;

import lesson3.stack.MyStack;
import org.jetbrains.annotations.NotNull;

public class Task2 {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(revertString(s));
    }

    @NotNull
    private static String revertString(@NotNull String s) {
        int length = s.length();
        MyStack<Character> chars = new MyStack<>(length);
        for (char c : s.toCharArray()) {
            chars.push(c);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.pop());
        }
        return sb.toString();
    }
}
