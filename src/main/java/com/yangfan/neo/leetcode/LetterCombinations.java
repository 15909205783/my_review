package com.yangfan.neo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static Map<Character, String> pairs = new HashMap<Character, String>();
    public static List<Character> tempList = new ArrayList<>();
    public static List<List<Character>> list = new ArrayList<>();

    static {
        pairs.put('2', "abc");
        pairs.put('3', "def");
        pairs.put('4', "ghi");
        pairs.put('5', "jkl");
        pairs.put('6', "mno");
        pairs.put('7', "pqrs");
        pairs.put('8', "tuv");
        pairs.put('9', "wxyz");
    }


    public static void main(String[] args) {
       String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        helper(digits, 0);
        for (List<Character> characters : list) {
            StringBuilder builder = new StringBuilder();
            for (Character character : characters) {
                builder.append(character);
            }
            result.add(builder.toString());
        }
        return result;
    }

    public static void helper(String digits, int index) {
        if (tempList.size() == digits.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        Character digit = digits.charAt(index);
        String letters = pairs.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            tempList.add(letters.charAt(i));
            helper(digits, index + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
