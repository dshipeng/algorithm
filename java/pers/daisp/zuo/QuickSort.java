package pers.daisp.zuo;

import pers.daisp.util.ArrayUtil;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

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

    private static void swap(int[] array, int i, int j) {
        if (i == j) return ;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int array[] = ArrayUtil.createRandomArray2(10);
            quickSort2(array, 0, 9);
            System.err.println(Arrays.toString(array));
        }
    }
}
