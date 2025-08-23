package Day9;

import java.util.Arrays;

public class LongestPrefix {

    public static String prefix(String[] strArr) {
        int len = strArr.length;
        if (len == 0)
            return "";
        if (len == 1)
            return strArr[0];

        String smallest = strArr[0];
        for (int i = 1; i < len; i++) {
            if (strArr[i].length() < smallest.length()) {
                smallest = strArr[i];
            }
        }

        for (int i = 0; i < smallest.length(); i++) {
            char ch = smallest.charAt(i);
            for (String s : strArr) {
                if (s.charAt(i) != ch) {
                    return smallest.substring(0, i);
                }
            }
        }

        return smallest;
    }

    public static void main(String[] args) {

        String[][] testCases = { { "flower", "flow", "flight" }, { "dog", "racecar", "car" },
                { "apple", "ape", "april" }, { "" }, { "alone" } };

        for (String[] test : testCases) {
            String pre = prefix(test);
            System.out.println(Arrays.toString(test) + " -> " + pre);
        }
    }
}
