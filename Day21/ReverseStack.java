package Day21;

import java.util.Stack;

public class ReverseStack {
    private static void helper(Stack<Integer> stack, int lastElement) {
        if (stack.isEmpty()) {
            stack.push(lastElement);
            return;
        }
        int topElement = stack.pop();
        helper(stack, lastElement);
        stack.push(topElement);
    }

    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int topElement = stack.pop();
            reverse(stack);
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
                { 3, 2, 1 },
                { 7, 1, 5 },
                { 5 },
                { -3, 14, 8, 2 },
                {},
                { 3, 3, 3 }
        };

        for (int[] test : testCases) {
            Stack<Integer> stack = buildStack(test);
            System.out.print(stack + "-> reversed -> ");
            reverse(stack);
            System.out.print(stack);
            System.out.println();
        }
    }
}
