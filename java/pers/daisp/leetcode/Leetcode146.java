package pers.daisp.leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class LRUCache {
    public static void main(String[] args) {
        Leetcode146 cache = new Leetcode146(2);
        cache.put(1,1);
        cache.put(2,2);
        System.err.println(cache.get(1));
        cache.put(3,3);
        System.err.println(cache.get(2));
        cache.put(4,4);
        System.err.println(cache.get(1));
        System.err.println(cache.get(3));
        System.err.println(cache.get(4));
    }
}

class Leetcode146 {
    int capacity;
    int size = 0;
    DoubleLinkList doubleLinkList;
    Map<Integer, Node> dataMap;

    public Leetcode146(int capacity) {
        this.capacity = capacity;
        doubleLinkList = new DoubleLinkList();
        dataMap = new ConcurrentHashMap();
    }

    public int get(int key) {
        if (!dataMap.containsKey(key))
            return -1;

        Node tmp = dataMap.get(key);
        doubleLinkList.remove(tmp);
        doubleLinkList.addTailer(tmp);

        return tmp.value;
    }

    public void put(int key, int value) {
        Node cur = new Node(key, value);
        if (dataMap.containsKey(key)) {
            doubleLinkList.remove(dataMap.get(key));
            doubleLinkList.addTailer(cur);
            dataMap.put(key, cur);
        } else {
            if (capacity == size) {
                Node head = doubleLinkList.removeHeader();
                dataMap.remove(head.key);
                size--;
            }
            size ++;
            dataMap.put(key, cur);
            doubleLinkList.addTailer(cur);
        }
    }
}


class DoubleLinkList {
    Node header;

    public void remove(Node node) {
        if (node == header) {
            removeHeader();
            return ;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public Node removeHeader() {
        Node temp = header;
        Node tail  = header.prev;
        header = header.next;
        header.prev = tail;
        tail.next = header;
        return temp;
    }

    public void addTailer(Node node) {
        if (header == null) {
            header = node;
            header.prev = header;
            header.next = header;
        } else {
            Node tail = header.prev;
            tail.next = node;
            node.prev = tail;
            node.next = header;
            header.prev = node;
        }
    }
}

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}