package com.yangfan.neo.leetcode;

public class IsPalindrome {

    public static void main(String[] args) {
        int x = 1213;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int res = 0;
        while (origin != 0) {
            int temp = origin % 10;
            res = res * 10 + temp;
            origin = origin / 10;
        }
        return res == x;
    }
}
