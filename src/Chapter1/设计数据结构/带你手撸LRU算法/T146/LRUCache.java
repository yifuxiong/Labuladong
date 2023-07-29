package Chapter1.设计数据结构.带你手撸LRU算法.T146;
// 这题我们先手写一遍实现 LinkedHashMap
// 熟悉一下 LinkedHashMap 这个数据结构
// 其实也就是链式哈希表

import java.util.HashMap;
import java.util.LinkedHashMap;

class Node {
    int key;
    int val;
    Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// 双向链表
class DoubleList {
    Node head, tail;
    int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;  // 这里需要返回删除的节点
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}

public class LRUCache {
    HashMap<Integer, Node> hashMap;
    DoubleList cache;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        hashMap = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return hashMap.get(key).val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cache.size() == cap) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    // 写 api，get和put函数只需调用这些api即可
    // 注意：哈希表和双向链表都需要改动

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node x = hashMap.get(key);
        // 先删除这个节点 x
        cache.remove(x);
        // 再插入到尾部
        cache.addLast(x);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 先插入双向链表
        cache.addLast(x);
        // 再在哈希表中添加key和node
        hashMap.put(key, x);
    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        // 先在哈希表中找到这个node
        Node x = hashMap.get(key);
        // 再在双向链表中删除这个node
        cache.remove(x);
        // 再在哈希表中删除这个key
        hashMap.remove(key);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 先在双向链表中删除这个node并返回
        Node x = cache.removeFirst();
        // 找到这个节点的key
        int key = x.key;
        // 再在哈希表中删除它的key
        hashMap.remove(key);
    }
}

/*
 * Java 的内置类型 LinkedHashMap 来实现 LRU 算法
 * */
class LRUCache2 {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}