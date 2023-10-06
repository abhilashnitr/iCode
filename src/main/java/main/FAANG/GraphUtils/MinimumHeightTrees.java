package main.FAANG.GraphUtils;

import java.util.*;

//Return a list of all MHTs' root labels. You can return the answer in any order.
//
//The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
public class MinimumHeightTrees {

//For a path graph of n nodes, find the minimum height trees is trivial. Just designate the middle point(s) as roots.
//Despite its triviality, let design a algorithm to find them.
//Suppose we don't know n, nor do we have random access of the nodes. We have to traversal. It is very easy to get the
//idea of two pointers. One from each end and move at the same speed. When they meet or they are one step away, (depends
//on the parity of n), we have the roots we want.
//This gives us a lot of useful ideas to crack our real problem.
//For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves). We
//let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two pointers
//meet or one step away we then find the roots.
//It is easy to see that the last two pointers are from the two ends of the longest path in the graph.
//The actual implementation is similar to the BFS topological sort. Remove the leaves, update the degrees of inner
//vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int[][] edge = {{1,0},{1,2},{1,3}};
        System.out.println(minimumHeightTrees.findMinHeightTrees(4,edge));

    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
