package com.yangfan.neo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
    public static boolean containsDuplicate(int[] nums){
        int length = nums.length;
        if (length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<length;i++){
            if (map.get(nums[i])==null) {
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value >=2){
                return true;
            }
        }
        return true;

    }
}
