/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            int v = cur.val;
            Node t = new Node(v);
            map.put(cur, t);
            cur = cur.next;
        }

        for(Map.Entry<Node, Node> entry: map.entrySet()){
            Node k = entry.getKey();
            Node v = entry.getValue();
            Node nnode = k.next;
            v.next = map.get(nnode);
            Node rnode  = k.random;
            v.random = map.get(rnode);
        }

        return map.get(head);
    }
}

// TC O(n)
// SC O(n)
