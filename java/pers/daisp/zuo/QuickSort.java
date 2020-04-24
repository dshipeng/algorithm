package pers.daisp.zuo;

import pers.daisp.util.ArrayUtil;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] array, int left, int right) {
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
        quickSort(array, left, i - 1);
        quickSort(array, j + 1, right);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int array[] = ArrayUtil.createRandomArray2(10);
            quickSort(array, 0, 9);
            System.err.println(Arrays.toString(array));
        }
    }
}
