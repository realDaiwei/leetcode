import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache /** extends LinkedHashMap<Integer, Integer> **/ {

    // 使用LinkedHashMap 实现的基础版本
    // private int capacity;

    // public LRUCache(int capacity) {
    //     super(capacity);
    //     this.capacity = capacity;
    // }
    
    // public int get(int key) {
    //     return this.getOrDefault(key, -1);
    // }
    
    // public void put(int key, int value) {
    //     super.put(key, value);
    // }

    // @Override
    // protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    //     return this.size() > capacity;
    // }

    class Node {

        private int key;
    
        private int value;

        private Node prev;
    
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    
    }

    private Integer size;

    private Node head; 

    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.next.prev = node.prev;
            node.prev.next = node.next;
            moveToHead(node);
            return;
        }
        if (map.size() > size - 1) {
            removeTail();
        }
        Node node = new Node(key, value);
        moveToHead(node);
        map.put(key, node);     
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeTail() {
        Node rm = tail.prev;
        rm.prev.next = tail;
        tail.prev = rm.prev;
        map.remove(rm.key);
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

