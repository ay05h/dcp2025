package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static List<List<String>> anagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Some test case
        String[][] testCases = {
                { "eat", "tea", "tan", "ate", "nat", "bat" },
                { " ", " " },
                { "a" },
                { "abc", "bca", "cab", "cba" },
                { "abc", "def", "ghi" },
                { "eat", "tea", "ate", "eat" }
        };
        for (String[] test : testCases) {
            List<List<String>> result = anagram(test);
            System.out.println(Arrays.toString(test) + " -> " + result);
        }
    }

}