package Day20;

import java.util.Stack;

public class SortStack {
    private static void helper(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int topElement = stack.pop();
        helper(stack, element);
        stack.push(topElement);

    }

    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int topElement = stack.pop();
            sort(stack);
            helper(stack, topElement);
        }
    }

    // Note: This method is not part of solution.
    // It is only a utility function to help me in testing.
    // It takes an int[] array as input and converts it into a Stack<Integer> so
    // that we can pass it to the sort function.
    private static Stack<Integer> buildStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        return stack;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 3, 1, 4, 2 },
                { 7, 1, 5 },
                { 5 },
                { -3, 14, 8, 2 },
                {},
                { 3, 3, 3 }
        };

        for (int[] test : testCases) {
            Stack<Integer> stack = buildStack(test);
            System.out.print(stack + "-> sorted -> ");
            sort(stack);
            System.out.print(stack);
            System.out.println();
        }
    }
}
