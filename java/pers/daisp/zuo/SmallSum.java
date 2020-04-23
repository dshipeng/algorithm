package pers.daisp.zuo;

import pers.daisp.util.ArrayUtil;

import java.util.Arrays;

/**
 * 小和
 * [1,3,2,6,5] 小和为：
 * 1 + 1 + 1+3+2 + 1+3+2 = 14
 */
public class SmallSum {
    private static int help[];
    private static final int ARRAY_LENGTH = 10;

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        int leftSum = mergeSort(arr, left, mid);
        int rightSum = mergeSort(arr, mid + 1, right);
        int curSum = mergeArray(arr, left, mid, right);
        return leftSum + rightSum + curSum;
    }

    private static int mergeArray(int[] arr, int left, int mid, int right) {
        int i = left, index = left;
        int j = mid + 1;
        int sum = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                help[index++] = arr[i];
                sum += arr[i++] * (right - j + 1);
            } else {
                help[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            help[index++] = arr[i];
            sum += arr[i++] * (right - j + 1);
        }
        while (j <= right) {
            help[index++] = arr[j++];
        }
        for (index = left; index <= right; index ++) {
            arr[index] = help[index];
        }
        return sum;
    }

    public static void main(String[] args) {
        help = new int[ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            int array[] = ArrayUtil.createRandomArray2(ARRAY_LENGTH);
            String arrayString = Arrays.toString(array);
            int rightResult = stupidMethod(array);
            int smallSum = mergeSort(array, 0, ARRAY_LENGTH - 1);
            System.err.println(arrayString + " " + smallSum + " " + rightResult);
        }
    }

    private static int stupidMethod(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
}
