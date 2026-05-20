package com.yangfan.neo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    public static void main(String[] args) {
        int longestValidParentheses = longestValidParentheses(")()())");
        System.out.println(longestValidParentheses);

    }

    /**
     * 最长的有效括号
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
