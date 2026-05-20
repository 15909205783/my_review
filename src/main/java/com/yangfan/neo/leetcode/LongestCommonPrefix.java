package com.yangfan.neo.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{
                "flower", "flow", "flight"
        };

        String commonstr = longestCommonPrefix(strs);
        System.out.println(commonstr);

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonStr = commonStr(commonStr, strs[i]);
        }
        return commonStr;
    }

    private static String commonStr(String str1, String str2) {
        int maxLength = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < maxLength && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
