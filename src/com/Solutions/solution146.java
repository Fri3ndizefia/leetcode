package com.Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 最少最近使用 置换算法
 * 自己创建一个双向链表
 * https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
 *
 */
public class solution146 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode dummyHead, dummyTail;

    /**
     * 此处solution146应该对应 LRUCache，对应的类名也是LRUCache
     * @param capacity
     */
    public solution146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果是空的，也就是说没有，就要创建一个新的节点给他
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出了容量，那么就要把尾部的节点给删掉（对应的最少最近使用的，LRU情况）
                DLinkedNode tail = removeTail();
                cache.remove(tail.key); // 哈希表中也要删除掉对应的key
                --size;
            }
        }else{
            // 如果该key存在，先定位，然后修改value，并且移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }
}
