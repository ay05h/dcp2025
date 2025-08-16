package Day2;

import java.util.Arrays;

public class FindMissingNumber {
    /*
     * Space Complexity : O(1)
     * Time Complexity : O(N)
     */
    public static int findMissingNum(int[] arr) {
        int len = arr.length;
        int totalXor = len + 1;
        int arrXor = 0;
        for (int i = 0; i < len; i++) {
            arrXor = arrXor ^ arr[i];
            totalXor = totalXor ^ (i + 1);
        }
        return totalXor ^ arrXor;
    }

    public static void main(String[] args) {
        // Some test cases
        int[][] testCases = {
                { 1, 2, 4, 5 },
                { 2, 3, 4, 5 },
                { 1, 2, 3, 4 },
                { 1 },
        };

        for (int[] test : testCases) {
            int missingNum = findMissingNum(test);
            System.out.println(Arrays.toString(test) + "-> " + missingNum);
        }
    }
}
