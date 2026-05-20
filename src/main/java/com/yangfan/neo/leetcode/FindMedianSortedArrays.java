package com.yangfan.neo.leetcode;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        //当m为0时
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[(n / 2) - 1] + nums2[(n / 2)]) / 2.0;
            } else {
                return nums2[(n / 2)];
            }
        }
        //当n为0时
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[(m / 2) - 1] + nums1[(m / 2)]) / 2.0;
            } else {
                return nums1[(m / 2)];
            }
        }

        //合并量数组
        int i = 0;
        int j = 0;
        int pos = 0;

        while (i + j < m + n) {
            if (i == m) {
                for (int k = j; k < n; k++) {
                    nums[pos++] = nums2[k];
                }
                break;
            }
            if (j == n) {
                for (int k = i; k < m; k++) {
                    nums[pos++] = nums1[k];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[pos++] = nums1[i++];
            } else {
                nums[pos++] = nums2[j++];
            }
        }
        int sum = m + n;
        if ((sum) % 2 == 0) {
            return (nums[(sum / 2) - 1] + nums[sum / 2]) / 2.0;
        } else {
            return nums[sum / 2];
        }
    }
}
