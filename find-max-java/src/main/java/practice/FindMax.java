package practice;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class FindMax {
    public int find(String expression) {
        int start = expression.indexOf('[');
        int end = expression.lastIndexOf(']');
        String numbers = expression.substring(start + 1, end);
        Optional<String> next = nextBlock(numbers);

        while (next.isPresent()) {
            numbers = numbers.replace(next.get(), Integer.toString(find(next.get())));
            next = nextBlock(numbers);
        }
        return getMax(numbers);
    }

    private int getMax(String numbers) {
        return Arrays.stream(numbers.split(",")).mapToInt(x -> Integer.parseInt(x.trim())).max().getAsInt();
    }

    private Optional<String> nextBlock(String numbers) {
        int start = numbers.indexOf('[');
        if (start > -1) {
            int end = findClosing(numbers, start);
            return Optional.of(numbers.substring(start, end + 1));
        }
        return Optional.empty();
    }

    private int findClosing(String numbers, int start) {
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (c == '[') {
                stack.push(i);
            } else if (c == ']') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
