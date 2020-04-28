package pers.daisp.util;

public class NumberUtil {
    public static int[] createRandomArray1(int length){
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        for (int i = 0; i < length; i++) {
            int random = (int) (length * Math.random());
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }
        return result;
    }

    public static int[] createRandomArray2(int length){
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (length * Math.random());
            result[i] = random;
        }
        return result;
    }

    public static int createRandomInt(int max) {
        return (int) (max * Math.random());
    }
}
