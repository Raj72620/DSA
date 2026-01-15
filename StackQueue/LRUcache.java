package StackQueue;
import java.util.*;

class LRUcache {
    
    static class Node {
        int key;
        int value;
        
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map;
    int cap;
    Node head, tail;
    
        LRUcache(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    void addNode(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    
    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    Node popTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            
            if (map.size() > cap) {
                Node lru = popTail();
                map.remove(lru.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUcache cache = new LRUcache(4);
        
        cache.put(2, 6);
        cache.put(4, 7);
        cache.put(8, 11);
        cache.put(7, 10);
        
        System.out.println("Get 2: " + cache.get(2)); 
        System.out.println("Get 8: " + cache.get(8)); 
        
        cache.put(5, 6);
        cache.put(5, 7); 
        
        System.out.println("Head next value: " + cache.head.next.value); 
    }
}