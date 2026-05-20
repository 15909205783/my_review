package com.yangfan.neo.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
//        int[] ints = twoSum(nums, 9);
        int[] ints = twoSumBySearch(nums, 9);
        System.out.println(ints.toString());
    }

    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumBySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
