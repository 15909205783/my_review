package com.yangfan.neo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        boolean[] used = new boolean[length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, used, length, 0, path, result);
        return result;
    }

    public static void dfs(int[] nums, boolean[] used, int length, int index, Deque<Integer> path, List<List<Integer>> result) {
        //
        if (path.size() == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, used, length, i + 1, path, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
