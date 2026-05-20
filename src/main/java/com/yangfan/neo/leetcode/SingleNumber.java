package com.yangfan.neo.leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        int result = singleNumber(nums);
        System.out.println(result);
    }
    public static int singleNumber(int[] nums){
        int ans = nums[0];
        if (nums.length>1){
            for (int i = 1;i<nums.length;i++){
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
