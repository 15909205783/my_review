package com.yangfan.neo.leetcode;

public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int ans = 0;
        int length = height.length;
        //第i根柱子前面最高的
        int[] leftHeight = new int[length];
        leftHeight[0] = height[0];
        for (int i = 1; i < length; i++) {
            int max = Math.max(height[i], leftHeight[i - 1]);
            leftHeight[i] = max;
        }

        //第i根柱子前面最高的
        int[] rightHeight = new int[length];
        rightHeight[length -1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            int max = Math.max(height[i], rightHeight[i + 1]);
            rightHeight[i] = max;
        }

        for (int i = 0; i < length; i++) {
            int min = Math.min(leftHeight[i], rightHeight[i]);
            ans = min +ans -height[i];
        }
        return ans;
    }
}
