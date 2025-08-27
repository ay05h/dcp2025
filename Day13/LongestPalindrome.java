package Day13;

public class LongestPalindrome {

    private static int helper(String str, int l, int r) {
        int len = str.length();
        while (l >= 0 && r < len && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 1)
            return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String[] testCases = { "babad", "cbbd", "aaaa", "a", "abc" };

        for (String s : testCases) {
            String palindrome = longestPalindrome(s);
            System.out.println(s + " -> " + palindrome);
        }
    }
}
