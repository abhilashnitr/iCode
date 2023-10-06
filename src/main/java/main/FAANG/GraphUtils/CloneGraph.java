package main.FAANG.GraphUtils;

import java.util.*;

public class CloneGraph {

    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }


    //I believe the time complexity is O(VE) in the worst case, where V is the # of nodes and E is the number of Edges(connections). I want to say space complexity would be O(V) in the worst case, since there can be a node that is connected to all other nodes.
    public Node cloneGraphBFS(Node node) {
        if(node==null) return node;

        Map<Node, Node> x = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        x.put(node, new Node(node.val));

        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node n : curr.neighbors){
                if(!x.containsKey(n)){
                    x.put(n, new Node(n.val));
                    queue.add(n);
                }
                x.get(curr).neighbors.add(x.get(n));
            }
        }

        return x.get(node);
    }

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
}

