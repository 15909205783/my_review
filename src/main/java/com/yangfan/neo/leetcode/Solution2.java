package com.yangfan.neo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));

        int[] array = new int[]{1, 2, 3};
        int[] ints = plusOne(array);


    }

    public static int lengthOfLastWord(String s) {
        String newString = s.trim();
        int length = newString.length();
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {

            if (newString.charAt(i) == ' ') {
                break;
            }
            result++;
        }
        return result;
    }


    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int extra = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            int cur = digits[i];
            cur = cur + extra;
            if (cur % 10 == 0) {
                list.add(0,cur);
                extra = 1;
            } else {
                list.add(0,cur);
                extra = 0;
            }
        }
        int[] array = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            array[i] = list.get(i);
        }
        return array;
    }


}
