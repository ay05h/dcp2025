package Day3;

import java.util.Arrays;

public class DuplicateNumber {
    /*
     * Space Complexity : O(1)
     * Time Complexity : O(N)
     */
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        while (true) {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (slow == fast) {
                break;
            }
        }

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
        // Some test cases
        int[][] testCases = {
                { 1, 3, 4, 2, 2 },
                { 3, 1, 3, 4, 2 },
                { 1, 1, 1 },
                { 1, 4, 4, 2, 3 },
        };

        for (int[] test : testCases) {
            int DuplicateNumber = findDuplicate(test);
            System.out.println(Arrays.toString(test) + "-> " + DuplicateNumber);
        }
    }

}
