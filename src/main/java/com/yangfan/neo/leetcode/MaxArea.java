package com.yangfan.neo.leetcode;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        //从右到左的遍历下标
        int i = 0;
        //右侧的最大下标
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            //最小木桶原理
            int area = Math.min(height[i], height[j]) * (j - i);
            //当前与最大面积进行比较
            ans = Math.max(ans, area);
            //根据高度进行判断，从最小高度向前（后）进行遍历
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }
}
