class LRUCache {
    Node l, r;
    Map<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        l = new Node();
        r = new Node();
        l.next = r;
        r.prev = l;
        map = new HashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }    
        return -1;
    }

    private void remove(Node node){
        Node lNode = node.prev;
        Node rNode = node.next;
        lNode.next = rNode;
        rNode.prev = lNode;
    }

    private void insert(Node node){
        Node prv = this.r.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.r;
        this.r.prev = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
        if(map.size() > this.cap){
            Node lrun = this.l.next;
            remove(lrun);
            map.remove(lrun.key);
        }
    }
}
class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){}

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}
