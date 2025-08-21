package Day7;

import java.util.Arrays;

public class RainTrap {

    public static int trappedWater(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (start < end) {
            if (arr[start] < arr[end]) {
                if (arr[start] >= leftMax) {
                    leftMax = arr[start];
                } else {
                    totalWater += leftMax - arr[start];
                }
                start++;
            } else {
                if (arr[end] >= rightMax) {
                    rightMax = arr[end];
                } else {
                    totalWater += rightMax - arr[end];
                }
                end--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        // Some test cases
        int[][] testCases = {
                { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 },
                { 4, 2, 0, 3, 2, 5 },
                { 1, 1, 1 },
                { 5 },
                { 2, 0, 2 },
        };

        for (int[] test : testCases) {
            int rain = trappedWater(test);
            System.out.println(Arrays.toString(test) + "->  rain : " + rain);
        }
    }
}
