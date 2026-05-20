package com.yangfan.neo.leetcode;


public class ReverseKGroup {

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            //先循环一组
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果剩余的长度不够，则跳出循环条件
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);

            //调换start、end、pre的位置继续循环
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }


    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
