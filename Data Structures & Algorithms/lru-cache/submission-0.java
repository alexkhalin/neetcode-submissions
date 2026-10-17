class LRUCache {

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map <Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.val : -1;
    }
    private void removeNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;

    }

    private void insertNode(Node node, Node prev) {
        node.prev = prev;
        node.next = prev.next;
        node.next.prev = node;
        prev.next = node;
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) return null;

        removeNode(node);
        insertNode(node, head);
        return node;
    }
    
    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }

        if (map.size() < capacity) {
            node = new Node(key, value);
        } else {
            node = tail.prev;
            removeNode(node);
            map.remove(node.key);
            node.key = key;
            node.val = value;
        }
        insertNode(node, head);
        map.put(key, node);
    }
}
