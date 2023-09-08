package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

How is this question different from Number of Islands?
In the Number of Islands question, you have a 2d grid. The number of "Nodes" if you will, are the cells of the grid.
So you have rows x columns in terms of the total number of nodes. Furthermore, the edges are represented by checking
whether the adjacent members are the 1 or not. This is why when you perform DFS, you need to have checks in
all 4 directions to add the neighbors.

In this question, you have a NxN matrix but only N friends in total. Edges are directly given via the cells so you have
to traverse a row (versus a 4 direction check) to get the neighbors for a specific matrix. In the Number of Islands
question, you can track visited by editing the original matrix. In this question, a separate array of length N can be used.

I hope that helped.
* */
public class  NumberofProvinces {
    public static void main(String[] args) {

        int[][] M = {{},{},{}};
    }

    /*
DFS
Complexity Analysis
Time complexity : O(n^2). The complete matrix of size n^2 is traversed.
Space complexity : O(n)O(n). visited array of size nn is used.
*/

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];//visited[i] means if ith person is visited in this algorithm
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                //We found an unvisited person in the current friend cycle
                visited[j] = 1;
                //Start DFS on this new found person
                dfs(M, visited, j);
            }
        }
    }


    /*
    BFS
    Complexity Analysis
    Time complexity : O(n^2) The complete matrix of size n^2 is traversed.
    Space complexity : O(n)O(n). A queue and visited array of size nn is used.
    */
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue< Integer > queue = new LinkedList< >();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }

    /*
    Union Find
    Time : O(n^3) two for loop and unionfind take O(n) in worst case
    Space : O(n) root array
    */
    public int findCircleNum3(int[][] M) {
        int m = M.length, cnt = 0;
        int[] root = new int[m];
        for (int i = 0; i < m; i++) root[i] = i;
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < m; j++)
                if (M[i][j] == 1) unionFind(root, i, j);

        for (int i = 0; i < m; i++)
            if (i == root[i]) cnt++;
        return cnt;
    }

    void unionFind (int[] root, int v1, int v2) {
        while (root[v1] != v1) v1 = root[v1]; //find v1's root
        while (root[v2] != v2) v2 = root[v2]; //find v2's root
        if (root[v1] != root[v2]) root[v2] = v1; //unite the 2 subtrees
    }

    //Union Find 2
    public int findCircleNum4(int[][] M) {
        int count = M.length;
        int[] root = new int[M.length];
        for(int i=0;i<M.length;i++){
            root[i] =i;
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    int rooti = findRoot(root,i);
                    int rootj = findRoot(root,j);
                    if(rooti!=rootj){
                        root[rooti] = rootj;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public int findRoot(int[] roots,int id){
        while(roots[id]!=id){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}


