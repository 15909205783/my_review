package com.yangfan.neo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = majorityElement(nums);
        long limit = nums.length >> 1;
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        Map<Integer,Integer> map = countNums(nums);
        int compareValue = nums[length / 2];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > compareValue){
                return key;
            }
        }
        return -1;
    }

    public static Map<Integer,Integer> countNums(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            Integer value = map.get(num);
            if(value == null){
                map.put(num,1);
            }else{
                map.put(num,value+1);
            }
        }
        return map;
    }
}
