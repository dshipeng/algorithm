package pers.daisp.nowcoder;

import pers.daisp.util.NumberUtil;

import java.util.Arrays;

public class HollandNationalFlag {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] array = NumberUtil.createRandomArray2(10);
            partition(array, 5);
            System.err.println(Arrays.toString(array));
        }
    }

    private static void partition(int[] array, int num) {
        int less = -1, more = array.length;
        int current = 0;

        while (current < more) {
            if (array[current] == num) {
                current ++;
            }else if (array[current] < num) {
                swap(array, ++less, current++);
            } else {
                swap(array, current, --more);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
