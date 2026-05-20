package com.yangfan.neo.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {

    public static Map<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public static void main(String[] args) {
     String   s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);

    }


    public static boolean isValid(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            Character symbol = s.charAt(i);
            if (pairs.containsKey(symbol)){
                if (pairs.containsKey(symbol)){
                    if (stack.isEmpty() || stack.peek() != pairs.get(symbol)){
                        return false;
                    }
                    stack.pop();
                }else {
                    stack.push(symbol);
                }
            }
        }
        return stack.isEmpty();
    }
}
