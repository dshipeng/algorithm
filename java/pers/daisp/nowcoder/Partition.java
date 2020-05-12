package pers.daisp.nowcoder;

import pers.daisp.util.NumberUtil;

import java.util.Arrays;

public class Partition {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] array = NumberUtil.createRandomArray2(10);
            partition(array, 5);
            System.err.println(Arrays.toString(array));
        }

    }

    private static void partition(int[] array, int num) {
        int lessIndex = -1, currentIndex = 0;
        while (currentIndex < array.length) {
            if (array[currentIndex] > num) {
                currentIndex ++;
                continue;
            }
            swap(array, ++lessIndex, currentIndex++);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
