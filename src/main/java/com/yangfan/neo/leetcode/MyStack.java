package com.yangfan.neo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public Integer pop() {
        return queue.poll();
    }

    public Integer top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }


}
