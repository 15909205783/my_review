package com.yangfan.neo.leetcode;

public class SubSet {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{3,4,5};
        boolean match = match(a, b);
        System.out.println(match);

    }

    public static boolean match(int[] a, int[] b) {
        if (b.length>a.length) {
            return false;
        }
        int j = 0;
        for (int i = 0;i<a.length;i++){
            int m = a[i];
            int n = b[j];
            if(m == n){
                j++;
            }
        }
        if(j < b.length){
            return false;
        }
        return true;
    }
}
