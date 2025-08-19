package Day5;

import java.util.*;

public class FindLeaders {

    public static int[] findLeaders(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return new int[] {};
        }
        List<Integer> leaders = new ArrayList<>();

        int currMax = arr[n - 1];
        leaders.add(currMax);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= currMax) {
                leaders.add(arr[i]);
                currMax = arr[i];
            }
        }
        int leaderSize = leaders.size();
        int[] leaderArray = new int[leaderSize];
        for (int i = 0; i < leaderSize; i++) {
            leaderArray[leaderSize - i - 1] = leaders.get(i);
        }
        return leaderArray;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 16, 17, 4, 3, 5, 2 },
                { 1, 2, 3, 4, 0 },
                { 7, 10, 4, 10, 6, 5, 2 },
                { 5 },
                { 100, 50, 20, 10 },
                { 1, 2, 3, 4, 5 },
                { 5, 4, 3, 2, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] leaders = findLeaders(testCases[i]);
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Leaders: " + Arrays.toString(leaders));
            System.out.println("-----");
        }
    }
}
