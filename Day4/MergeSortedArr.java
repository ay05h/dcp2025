package Day4;

import java.util.Arrays;

public class MergeSortedArr {
    private static void swap(int[] arr1, int[] arr2, int idx1, int idx2) {
        int temp = arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
    }

    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {
                if (i < n && j < n) {
                    if (arr1[i] > arr1[j]) {
                        swap(arr1, arr2, i, j);
                    }
                } else if (i < n && j >= n) {
                    if (arr1[i] > arr2[j - n]) {
                        swap(arr1, arr2, i, j - n);
                    }
                } else {
                    if (arr2[i - n] > arr2[j - n]) {
                        swap(arr1, arr2, i - n, j - n);
                    }
                }
                i++;
                j++;
            }
            gap = nextGap(gap);
        }
    }

    public static void main(String[] args) {
        // Some test cases
        int[][] arr1Cases = {
                { 1, 3, 5 },
                { 10, 12, 14 },
                { 2, 3, 8 },
                { 1 }
        };
        int[][] arr2Cases = {
                { 2, 4, 6 },
                { 1, 3, 5 },
                { 4, 6, 10 },
                { 2 }
        };

        for (int i = 0; i < arr1Cases.length; i++) {
            merge(arr1Cases[i], arr2Cases[i]);
            System.out.println(Arrays.toString(arr1Cases[i]) + " " + Arrays.toString(arr2Cases[i]));
        }
    }

}
