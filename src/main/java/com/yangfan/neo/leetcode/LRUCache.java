package com.yangfan.neo.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
 * 如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 */
public class LRUCache {
    private int capacity;
    private int size;
    private Map<Integer, Node> cacheMap;

    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        moveHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            //放入map
            cacheMap.put(key, newNode);
            //添加到双向链表的对首
            addHead(newNode);
            ++size;
            if (size > capacity) {
                removeTail();
                cacheMap.remove(key);
                --size;
            }

        } else {
            node.value = value;
            moveHead(node);
        }

    }

    private void removeTail() {
        Node pre = tail.pre;
        removeNode(pre);
    }

    private void moveHead(Node node) {
        removeNode(node);
        addHead(node);
    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node pre = node.pre;
        pre.next = next;
        next.pre = pre;
    }

    private void addHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}
