package com.yangfan.neo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date：2026/5/25
 * @Description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * @Author：yangwuhai
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        Integer[] ts = {100,4,200,1,3,2};
        longestConsecutive(ts);
    }

    public static int longestConsecutive(Integer[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!numSet.contains(num-1)) {//简单来说就是每个数都判断一次这个数是不是连续序列的开头那个数。
                int curNum = num;
                int curLength = 1;
                while (numSet.contains(curNum+1)){
                    curNum +=1;
                    curLength +=1;
                }
                result = Math.max(curLength,result);
            }
        }
        return result;
    }

}
