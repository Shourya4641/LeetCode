class LRUCache {
    // Node class is used to store the cache
    // it consists of key, value and a pointer pointing to the next and previous node
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // initializing the head and tail pointer for the doubly linked list
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    // store the capacity of the cache 
    int cacheSize = 0;

    // a hashmap to store the key and address of the node which consists of the value.
    // this would help in getting to the node in the doubly linked list easily
    HashMap<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        // initialize the cache size with the given capacity
        cacheSize = capacity;

        // initialize the doubly linked list with no node between the head and tail node
        head.next = tail;
        tail.prev = head;
    }

    // whenever there is a key value pair that has to be added in the cache, that should be updated in the linked list
    // make sure to keep the most recently used pair next to the head
    // and keep the least recently used pair previous to the tail
    private void addNode(Node newNode) {
        Node temp = head.next;

        newNode.prev = head;
        newNode.next = temp;

        temp.prev = newNode;
        head.next = newNode;
    }

    // when the cache is full, then we have to delete the node which is least recently used
    // the least recently used node is present at the just previous position of the tail node
    private void deleteNode(Node oldNode) {
        Node previousToOldNode = oldNode.prev;
        Node nextToOldNode = oldNode.next;

        nextToOldNode.prev = previousToOldNode;
        previousToOldNode.next = nextToOldNode;
    }
    
    public int get(int key) {
        // check if the key is present in the hashmap
        // if present, then get the node address from the map
        // store the value
        // remove the node from it's current location and add it to the new location since it becomes the most recently used pair
        if (nodeMap.containsKey(key)) {
            Node currentNode = nodeMap.get(key);
            int value = currentNode.value;

            nodeMap.remove(key);

            deleteNode(currentNode);
            addNode(currentNode);

            nodeMap.put(key, head.next);

            return value;
        }
        // if key doesn't exist in the hashmap then return -1
        return -1;
    }
    
    public void put(int key, int value) {
        // if the given key exists in the hashmap then delete the corresponding key and node address
        // and then add the key-value pair in a new node and then add them next to the head node
        if (nodeMap.containsKey(key)) {
            Node currentNode = nodeMap.get(key);
            nodeMap.remove(key);
            deleteNode(currentNode);
        }

        // if given pair doesn't exist then check the size of the cache and then accordingly add or delete the node from the linked list
        if (nodeMap.size() == cacheSize) {
            nodeMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        nodeMap.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */