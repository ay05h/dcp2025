package Day12;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean validate(String str) {
        if (str.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = { "()", "([)]", "[{()}]", "", "{[}" };

        for (String s : testCases) {
            boolean check = validate(s);
            System.out.println(s + " -> " + check);
        }
    }
}
