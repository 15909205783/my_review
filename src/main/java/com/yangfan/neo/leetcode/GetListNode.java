package com.yangfan.neo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class GetListNode {
    public static ListNode getHead() {
        ListNode l6 = new ListNode(1, null);
        ListNode l5 = new ListNode(2, l6);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(5, l3);
        ListNode l1 = new ListNode(6, l2);
        return l1;
    }

    public static void main(String[] args) {

        //接雨水
        List<Integer> list = Arrays.asList(4, 2, 0, 3, 2, 5);

        Integer[] height = list.toArray(new Integer[0]);
        int ans = fun(height);
        System.out.println(ans);



        //删除链表的倒数第n个元素
        ListNode head = getHead();
//        ListNode listNode = removeNthFromEnd_2(head, 3);
//        System.out.println(listNode);
        //回文链表
       /* boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);*/
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        merged.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int L = intervals[i][0], R = intervals[i][1];
            //动态规划：当前区间的左端点大于上一个区间的右端点，就直接把当前区间直接加进去
            if( merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            }else{
                int mergedRight = merged.get(merged.size() - 1)[1];
                mergedRight =  Math.max(mergedRight,R);
                merged.get(merged.size() - 1)[1] = mergedRight;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    //接雨水
    public static int fun(Integer[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            //动态规划，当前柱子的最大高度就是当前柱子的高度，和前面一个柱子最小高度之差，
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            //为什么是i+1，因为是逆向循环的
            //动态规划，当前柱子的最大高度就是当前柱子的高度，和前面一个柱子最小高度之差，
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            //当前柱子左右两端最小的高度，最小水桶理论
            int curMinHeight = Math.min(leftMax[i], rightMax[i]);
            //当前柱子能装的水
            int cotain = curMinHeight - height[i];
            // 总的装水量
            ans = ans + cotain;

        }
        return ans;

    }

    //19. 删除链表的倒数第 N 个结点
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode firstHead = head;
        ListNode cur = dummy;
        int length = 0;
        while (firstHead != null) {
            firstHead = firstHead.next;
            length++;
        }
        int secondCount = 0;
        int removeLocation = length - n;
        while (cur != null) {
            if (secondCount == removeLocation) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            secondCount++;
        }
        System.out.println(head);
        return dummy.next;
    }

    //19. 删除链表的倒数第 N 个结点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        //先行n步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //找到第n个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //移除第n个节点
        ListNode next = slow.next.next;
        slow.next = next;
        return dummy.next;
    }


    //回文链表
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int size = stack.size();
        ListNode temp = slow;
        if (size % 2 == 0 || size == 1) {

            temp = slow;
        } else {
            temp = slow.next;
        }
        while (temp != null) {
            int top = stack.peek();
            int curr = temp.val;
            temp = temp.next;
            if (top != curr) {
                return false;
            }
            stack.pop();

        }
        return stack.isEmpty();
    }
}
