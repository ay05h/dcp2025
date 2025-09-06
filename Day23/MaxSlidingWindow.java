package Day23;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
    public static int[] findMaxArray(int[] arr, int k) {
        int[] maxArr = new int[arr.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int pointer = i - k + 1;
            if (!dq.isEmpty() && dq.peekFirst() < pointer) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                maxArr[pointer] = arr[dq.peekFirst()];
            }
        }
        return maxArr;
    }

    public static void main(String[] args) {

        int[][] testArrays = {
                { 1, 3, -1, -3, 5, 3, 6, 7 },
                { 1, 5, 3, 2, 4, 6 },
                { 1, 2, 3, 4 },
                { 7, 7, 7, 7 },
        };

        int[] k = { 3, 3, 2, 1 };

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = findMaxArray(testArrays[i], k[i]);
            System.out.println("Input: " + Arrays.toString(testArrays[i]) + ", k = " + k[i] + " -> Output: " + Arrays
                    .toString(result));
        }
    }
}
