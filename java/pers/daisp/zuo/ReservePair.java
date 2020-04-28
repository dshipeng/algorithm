package pers.daisp.zuo;

import pers.daisp.util.NumberUtil;

import java.util.Arrays;

/**
 * 逆序数：在一个排列中，如果一对数的前后位置与大小顺序相反，
 * 　　　　即前面的数大于后面的数，那么它们就称为一个逆序。
 * 　　　　一个排列中逆序的总数就称为这个排列的逆序数。
 */
public class ReservePair {
    static int help[];
    private static final int ARRAY_LENGTH = 5;

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        int leftCount = mergeSort(arr, left, mid);
        int rightCount = mergeSort(arr, mid + 1, right);
        int curCount = mergeArray(arr, left, mid, right);
        return leftCount + rightCount + curCount;
    }

    private static int mergeArray(int[] arr, int left, int mid, int right) {
        int i = left, index = left;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                help[index++] = arr[i++];
            } else {
                count += mid - i + 1;
                help[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            help[index++] = arr[i++];
        }

        while (j <= right) {
            help[index++] = arr[j++];
        }
        for (index = left; index <= right; index ++) {
            arr[index] = help[index];
        }
        return count;
    }

    public static void main(String[] args) {
        help = new int[ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            int array[] = NumberUtil.createRandomArray2(ARRAY_LENGTH);
            String arrayString = Arrays.toString(array);
            int rightResult = stupidMethod(array);
            int smallSum = mergeSort(array, 0, ARRAY_LENGTH - 1);
            System.err.println(arrayString + " " + smallSum + " " + rightResult);
        }
    }

    private static int stupidMethod(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count ++;
                }
            }
        }
        return count;
    }
}
