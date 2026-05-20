package com.yangfan.neo.leetcode;

import java.util.Stack;

public class IsPalindrome1 {
    public static void main(String[] args) {
//        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "9,8";
//        boolean palindrome = isPalindrome(s1);
        boolean palindrome1 = isPalindrome(s2);
//        System.out.println(palindrome);
        System.out.println(palindrome1);

    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        String str = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if ((c >= '0' && c < '9') || (c >= 'a' && c <= 'z')) {
                stack.push(c);
            }
        }
        for (int i = 0; i < length; i++) {
            int c = str.charAt(i);
            if ((c >= '0' && c < '9') || (c >= 'a' && c <= 'z')) {
                char temp = stack.pop();
                if (temp != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
