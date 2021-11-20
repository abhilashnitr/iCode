package main.FAANG.GraphUtils;

import java.util.Arrays;

public class GraphValidTree {

    public static void main(String[] args) {

        int nodes=5;
        int[][] edges={{0,1},{0,2},{0,3},{1,4}};
        GraphValidTree graphValidTree=new GraphValidTree();
        System.out.println(graphValidTree.validTree(nodes,edges));

    }
    public  boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
