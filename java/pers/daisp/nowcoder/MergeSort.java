package pers.daisp.nowcoder;

import pers.daisp.util.NumberUtil;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    static int help[];
    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return ;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeArray(arr, left, mid, right);
    }

    private static void mergeArray(int[] arr, int left, int mid, int right) {
        int i = left, index = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            help[index ++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
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
    }

    public static void main(String[] args) {
        help = new int[10];
        for (int i = 0; i < 100; i++) {
            int array[] = NumberUtil.createRandomArray2(10);
            mergeSort(array, 0, 9);
            System.err.println(Arrays.toString(array));
        }
    }
}
