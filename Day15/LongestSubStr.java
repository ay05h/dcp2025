package Day15;

import java.util.HashMap;

public class LongestSubStr {

    public static int longestDistinctStr(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int start = 0;
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            int prevIdx = map.getOrDefault(c, -1);
            if (prevIdx >= start) {
                start = prevIdx + 1;
            }
            map.put(c, end);
            int len = end - start + 1;
            longest = Math.max(longest, len);

        }

        return longest;
    }

    public static void main(String[] args) {
        String[] testCases = { "abcabcbb", "bbbbbb", "pwwkew", "a", "abcdefgh" };

        for (String s : testCases) {
            int longest = longestDistinctStr(s);
            System.out.println(s + " -> " + longest);
        }

    }
}
