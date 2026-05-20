package com.yangfan.neo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEndByPoint(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        //快指针先行n步
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

    //使用栈删除
    public static ListNode removeNthFromEndByStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        //出栈
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndByLocation(ListNode head, int n) {
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

        return dummy.next;
    }


}
