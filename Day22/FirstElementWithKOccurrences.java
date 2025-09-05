package Day22;

import java.util.HashMap;
import java.util.Arrays;

public class FirstElementWithKOccurrences {
    public static int findFirstKTimes(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == k) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] testArrays = {
                { 3, 1, 4, 4, 5, 2, 6, 1, 4 },
                { 2, 3, 4, 2, 2, 5, 5 },
                { 1, 1, 1, 1 },
                { 10 },
                { 6, 6, 6, 6, 7, 7, 8, 8, 8 },
                { 1, 2, 3, 4 },
                { -1, -2, -1, -3, -2, -2 },
                { 0, 1, 0, 2, 3, 2 }
        };

        int[] k = { 2, 2, 1, 1, 3, 2, 2, 2 };

        for (int i = 0; i < testArrays.length; i++) {
            int result = findFirstKTimes(testArrays[i], k[i]);
            System.out.println("Input: " + Arrays.toString(testArrays[i]) + ", k = " + k[i] + " -> Output: " + result);
        }
    }

}
