package pers.daisp.nowcoder;

import pers.daisp.util.NumberUtil;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    private static final int ARRAY_LENGTH = 10;
    private static final int ARRAY_COUNT = 100;

    /**
     * 挖坑法
     */
    private static void quickSort1(int[] array, int left, int right) {
        if (left > right) return ;
        int temp = array[left];
        int i = left, j = right;
        while (i < j) {
            while (array[j] >= temp && j > i) {
                j --;
            }
            if (j > i) {
                array[i] = array[j];
            }

            while (array[i] <= temp && i < j) {
                i ++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = temp;
        quickSort1(array, left, i - 1);
        quickSort1(array, j + 1, right);
    }

    /**
     * 左右指针法
     */
    private static void quickSort2(int[] array, int left, int right) {
        if (left >= right) return ;
        int temp = array[right];
        int i = left, j = right;
        while (i < j) {
            while (array[i] <= temp && i < j) {
                i++;
            }
            while (array[j] >= temp && j > i) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, right);
        quickSort2(array, left, i - 1);
        quickSort2(array, j, right);
    }

    /**
     * 前后指针法
     */
    private static  void quickSort3(int[] array, int left, int right) {
        if (left >= right) return ;
        int cur = left;
        int prev = left - 1;
        int temp = array[right];
        while (cur < right) {
            while (array[cur] >= temp && cur < right) {
                cur++;
            }
            if (cur < right) {
                prev++;
                swap(array, prev, cur);
                cur++;
            }
        }
        swap(array, ++prev, right);
        quickSort3(array, left, prev - 1);
        quickSort3(array, prev + 1, right);
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) return ;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < ARRAY_COUNT; i++) {
            int array[] = NumberUtil.createRandomArray2(ARRAY_LENGTH);
            quickSort3(array, 0, ARRAY_LENGTH - 1);
            System.err.println(Arrays.toString(array));
        }
    }
}
