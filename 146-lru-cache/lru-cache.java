class Node {
    Node prev;
    Node next;
    int value;
    int key;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node recentNode = cache.get(key);
        int value = recentNode.value;

        recentNode.prev.next = recentNode.next;
        recentNode.next.prev = recentNode.prev;

        // Move it to the front (most recent position)
        recentNode.next = head.next;
        recentNode.next.prev = recentNode;
        head.next = recentNode;
        recentNode.prev = head;

        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node current = cache.get(key);
            current.value = value;

            current.prev.next = current.next;
            current.next.prev = current.prev;

            current.next = head.next;
            current.next.prev = current;
            head.next = current;
            current.prev = head;

            return;

        }
        // capacity is full, we need to delete
        if (capacity == cache.size()) {
            cache.remove(tail.prev.key);
            Node recentNode = tail.prev;
            recentNode.prev.next = recentNode.next;
            recentNode.next.prev = recentNode.prev;

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            newNode.next = head.next;
            newNode.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            newNode.next = head.next;
            newNode.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */