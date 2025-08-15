package Day1;

import java.util.Arrays;

public class SortArrayOf_1_2_3 {
    /*
     * Space Complexity : O(1)
     * Time Complexity : O(N)
     */
    public static void sort_1_2_3(int arr[]) {
        int pointer_0 = 0;
        int pointer_2 = arr.length - 1;
        int pointer = 0;

        while (pointer <= pointer_2) {
            if (arr[pointer] == 0) {
                arr[pointer] = arr[pointer_0];
                arr[pointer_0] = 0;
                pointer_0++;
                pointer++;
            } else if (arr[pointer] == 2) {
                arr[pointer] = arr[pointer_2];
                arr[pointer_2] = 2;
                pointer_2--;
            } else {
                pointer++;
            }
        }
    }

    public static void main(String[] args) {
        // Some test cases
        int[][] testCases = {
                { 0, 1, 2, 1, 0, 2, 1, 0 },
                { 2, 2, 2, 2 },
                { 2, 0, 1 },
                {},
                { 0, 1, 2 },
                { 2, 1, 0 },
                { 0 },
        };

        for (int[] test : testCases) {
            sort_1_2_3(test);
            System.out.println(Arrays.toString(test));
        }
    }
}
