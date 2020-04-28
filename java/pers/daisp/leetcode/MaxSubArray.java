package pers.daisp.leetcode;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int res=nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-2, 4, -3, 5};
        System.err.println(maxSubArray(array));
    }
}
