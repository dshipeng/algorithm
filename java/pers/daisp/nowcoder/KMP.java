package pers.daisp.nowcoder;

public class KMPnextArray {

    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String subStr = "ABCDABD";
        System.err.println(KMP(str.toCharArray(), subStr.toCharArray()));
    }

    private static int KMP(char[] chars, char[] subChars) {
        int[] next = genNextArr(subChars);
        int i = 0;
        int j = 0;
        while (i < chars.length && j < subChars.length) {
            if (chars[i] == subChars[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (j == subChars.length) {
            return i - j;
        }
        return -1;
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
