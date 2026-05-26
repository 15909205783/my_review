package com.yangfan.neo.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @Date：2026/5/25
 * @Description:
 * @Author：yangwuhai
 */
public class LRUCacheBaseMap extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCacheBaseMap(int initialCapacity) {
        super(initialCapacity, 0.75F,true);
        this.capacity = capacity;
    }

    public Integer get(Integer key){
       return super.getOrDefault(key,-1);
    }

    public void put(Integer key,Integer value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
