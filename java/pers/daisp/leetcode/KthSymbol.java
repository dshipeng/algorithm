package pers.daisp.leetcode;

public class KthSymbol {
    public static int kthGrammar(int N, int K) {
        int[] array = genChar(N);
        return array[K];
    }

    public static int[] genChar(int N) {
        if (N == 1) return new int[]{0};

        int[] pre = genChar(N - 1);
        int[] result = new int[pre.length * 2];
        for (int i = 0; i < pre.length; i++) {
            result[2 * i] = pre[i];
            result[2 * i + 1] = 1 - pre[i];
        }
        return result;
    }
}
