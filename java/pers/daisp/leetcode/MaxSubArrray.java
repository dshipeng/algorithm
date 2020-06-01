package pers.daisp.leetcode;

public class MaxSubArrray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        int maxSum = nums[0];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sums[i - 1] < 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = nums[i] + sums[i-1];
            }
            maxSum = maxSum > sums[i] ? maxSum : sums[i];
        }
        return maxSum;
    }
}
