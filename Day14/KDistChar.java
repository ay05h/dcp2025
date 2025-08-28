package Day14;

public class KDistChar {

    public static int atMostK(String str, int k) {
        int count = 0;
        int[] map = new int[26];
        int start = 0;
        int unique = 0;
        for (int end = 0; end < str.length(); end++) {
            int pos = str.charAt(end) - 'a';
            if (map[pos] == 0) {
                unique++;
            }
            map[pos] += 1;

            while (unique > k) {
                int idx = str.charAt(start) - 'a';
                map[idx] -= 1;
                if (map[idx] == 0) {
                    unique--;
                }
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

    public static int exactK(String s, int k) {
        {
            return atMostK(s, k) - atMostK(s, k - 1);
        }

    }

    public static void main(String[] arg) {
        String[][] testCases = {
                { "pqpqs", "2" },
                { "aabacbebebe", "3" },
                { "a", "1" },
                { "abc", "3" },
                { "abc", "2" },
                { "", "1" },
                { "aaaa", "1" },
                { "aaaa", "2" },
                { "abcd", "5" },
                { "abcd", "1" }
        };
        for (String[] s : testCases) {
            int numSubStr = exactK(s[0], Integer.parseInt(s[1]));
            System.out.println(s[0] + ", " + s[1] + " -> " + numSubStr);
        }

    }
}