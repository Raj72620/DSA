package StackQueue;
import java.util.*;

class LFUcache {
    
    static class Node {
        int key;
        int value;
        int freq;
        
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
 
    static class DoublyLL {
        Node head;
        Node tail;
        int size;
        
        DoublyLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        void addNode(Node node) {
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
        }
        
        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        
        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                removeNode(last);
                return last;
            }
            return null;
        }
    }

    Map<Integer, Node> nodeMap;
    Map<Integer, DoublyLL> freqMap;
    int capacity;
    int minfreq;
    
     LFUcache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minfreq = 0;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (nodeMap.size() == capacity) {
                DoublyLL minList = freqMap.get(minfreq);
                Node toRemove = minList.removeLast();
                nodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            minfreq = 1;
            freqMap.putIfAbsent(1, new DoublyLL());
            freqMap.get(1).addNode(newNode);
        }
    }
    
    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLL oldList = freqMap.get(oldFreq);
        
        if (oldList != null) {
            oldList.removeNode(node);
            if (oldFreq == minfreq && oldList.size == 0) {
                minfreq++;
            }
        }
        
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLL());
        freqMap.get(node.freq).addNode(node);
    }
    
    public static void main(String[] args) {
        LFUcache cache = new LFUcache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1)); 
        
        cache.put(3, 3); 
        System.out.println("Get 2: " + cache.get(2)); 
        System.out.println("Get 3: " + cache.get(3)); 
        
        cache.put(4, 4); 
        System.out.println("Get 1: " + cache.get(1)); 
        System.out.println("Get 3: " + cache.get(3)); 
        System.out.println("Get 4: " + cache.get(4)); 
    }
}