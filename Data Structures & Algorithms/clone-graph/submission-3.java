/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> mp = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        
        mp.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty()){
            Node n = q.poll();
            for(Node nei: n.neighbors){
                if(!mp.containsKey(nei)){
                    q.add(nei);
                    mp.put(nei, new Node(nei.val));
                } 
                mp.get(n).neighbors.add(mp.get(nei));
            }
        }
        return mp.get(node);
    }
}

// TC O(Vertices + Edges) because we only iterate for each vertice's neighbors only
// SC O(V) map size