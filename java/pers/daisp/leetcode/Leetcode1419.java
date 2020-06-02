package pers.daisp.leetcode;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 *
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 */
public class Leetcode1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] charArray = croakOfFrogs.toCharArray();
        int numC = 0, numR = 0, numO = 0, numA = 0, numK = 0;

        int numKLast = 0;
        int chongfu = 0;
        for (int i = 0; i < charArray.length; i++) {
            numC += charArray[i] == 'c' ? 1: 0;
            numR += charArray[i] == 'r' ? 1: 0;
            numO += charArray[i] == 'o' ? 1: 0;
            numA += charArray[i] == 'a' ? 1: 0;
            numK += charArray[i] == 'k' ? 1: 0;
            numKLast += charArray[i] == 'k' ? 1: 0;
            if (numK > numA || numA > numO || numO > numR || numR > numC) return -1;
            if (charArray[i] == 'c' && numKLast > 0) {
                numKLast --;
                chongfu --;
            }
        }
        if (numK == numA && numA == numO && numO == numR && numR == numC) return numA + chongfu;
        return -1;
    }
}
