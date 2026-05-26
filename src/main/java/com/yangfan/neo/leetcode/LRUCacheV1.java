package com.yangfan.neo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date：2026/5/25
 * @Description: LRU缓存
 * @Author：yangwuhai
 */
public class LRUCacheV1 {

    private int size;
    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node tail;
    private Node head;

    public LRUCacheV1(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.tail = new Node();
        this.head = new Node();
    }

    class Node {

        private int key;
        private int val;

        private Node next;
        private Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    public void put(int key, int val) {
        Node node = cacheMap.get(key);

        if (node == null) {
            Node newNode = new Node(key, val);
            //放入map
            cacheMap.put(key, newNode);
            //添加到双向链表的对首
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                deleteTail();
                Node endNode = cacheMap.remove(key);
                cacheMap.remove(endNode.key);
                --size;
            }

        } else {
            node.val = val;
            this.moveToHead(node);
        }
    }

    private Node deleteTail() {
        Node node = tail.pre;
        removeCur(node);
        return node;
    }


    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        removeCur(node);
        addToHead(node);
    }

    private void removeCur(Node node) {
        Node next = node.next;
        Node pre = node.pre;

        pre.next = next;
        next.pre = pre;

        node.pre.next = node.next;
        node.next.pre = node.pre;


    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;

        head.next = node;
        node.pre = head;
    }

}
