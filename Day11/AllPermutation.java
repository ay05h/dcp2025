package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutation {
    public static List<String> permutation(String s) {
        List<String> perms = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(chars, new StringBuilder(), used, perms);
        return perms;
    }

    private static void backtrack(char[] chars, StringBuilder curr, boolean[] used, List<String> perms) {
        if (curr.length() == chars.length) {
            perms.add(curr.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            curr.append(chars[i]);
            backtrack(chars, curr, used, perms);
            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] testCases = { "abc", "aab", "aaa", "a", "abcd" };

        for (String test : testCases) {
            List<String> perms = permutation(test);
            System.out.println(test + " -> " + perms);
        }
    }
}
