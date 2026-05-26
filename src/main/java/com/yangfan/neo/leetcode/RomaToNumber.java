package com.yangfan.neo.leetcode;

/**
 * @Date：2026/5/20
 * @Description:
 * @Author：yangwuhai
 */
public class RomaToNumber {

    public static void main(String[] args) {
        System.out.println("----->"+ (15 / 10));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        String[] nums = s.split("");
        int sum = 0;
        int pre = getValue(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = getValue(nums[i]);
            if (pre < num) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = num;
        }
        String xx = "111";
        xx.length();
        char c = xx.charAt(1);
        boolean b = xx.charAt(0) == c;


        sum += pre;
        return sum;

    }

    private static int getValue(String ch) {
        switch (ch) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }

}
