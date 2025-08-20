package Day6;

import java.util.*;

public class SubArrayWithSumZero {

    public static List<int[]> findSubArrWithSumZero(int[] arr) {
        List<int[]> subArr = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int idx : map.get(sum)) {
                    subArr.add(new int[] { idx + 1, i });
                }
                map.get(sum).add(i);
            } else {
                map.put(sum, new ArrayList<>());
                map.get(sum).add(i);
            }

        }

        return subArr;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 2, -3, 3, -1, 2 },
                { 4, -1, -3, 1, 2, -1 },
                { 1, 2, 3, 4 },
                { 0, 0, 0 },
                { -3, 1, 2, -3, 4, 0 },
                { 1, -1, 2, -2, 3, -3 },
                { 0 },
                { 5 }
        };

        for (int i = 0; i < testCases.length; i++) {
            List<int[]> result = findSubArrWithSumZero(testCases[i]);
            System.out.println("Input: " + Arrays.toString(testCases[i]));

            if (result.isEmpty()) {
                System.out.println("Zero-sum subarrays: []");
            } else {
                System.out.print("Zero-sum subarrays: ");
                for (int[] arr : result) {
                    System.out.print(Arrays.toString(arr));
                }
                System.out.println();

            }
            System.out.println("-----");
        }
    }

}
