package Day19;

import java.util.Stack;

public class EvaluatePostfix {
    public static int evalPostfix(String str) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = str.trim().split("\\s+");

        for (String token : tokens) {

            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } else {
                stack.push(Integer.parseInt(token));
            }

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] testCases = { "2 1 + 3 *", "5 6 +", "-5 6 -", "15 7 1 1 + - / 3 * 2 1 1 + + -", "5" };

        for (String str : testCases) {
            int result = evalPostfix(str);
            System.out.println(str + " -> " + result);
        }
    }
}
