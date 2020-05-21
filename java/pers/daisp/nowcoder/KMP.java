package pers.daisp.nowcoder;

import java.util.Arrays;

public class KMPnextArray {

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'g', 'c', 't', 'a', 'g', 'c', 'a', 'g', 'c', 't', 'a', 'g', 'c', 't'};
        System.err.println(Arrays.toString(genNextArr(chars)));
    }


    private static int[] genNextArr(char[] charArr) {
        if (charArr.length == 0) return new int[0];
        int[] next = new int[charArr.length];
        next[0] = 0;
        int cur = 1;
        while (cur < charArr.length) {
            int tmp = next[cur - 1];
            while (charArr[cur] != charArr[tmp] && tmp != 0) {
                tmp = next[tmp - 1];
            }
            if (charArr[cur] == charArr[tmp]) {
                next[cur] = tmp + 1;
            } else {
                next[cur] = 0;
            }
            cur++;
        }
        return next;
    }
}
