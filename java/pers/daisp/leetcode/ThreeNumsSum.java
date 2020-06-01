package pers.daisp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumsSum {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,1,2,-1,-1,-4};
        int[] nums = new int[]{0,0,0,0};
        System.err.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <3) return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length - 2; index ++) {
            if (index > 0 && nums[index] == nums[index-1]) continue;

            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[index], nums[left], nums[right])));
                    right --;
                    while (right > left && nums[right] == nums[right+1]) right --;
                    left ++;
                    while (right > left && nums[left] == nums[left-1]) left ++;
                }
                if (sum > 0) {
                    right --;
                }
                if (sum < 0) {
                    left ++;
                }
            }
        }
        return result;
    }
}
