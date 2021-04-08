package main.FAANG.GraphUtils;
/*
There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.
*/
/*
We need at least n - 1 cables to connect all nodes (like a tree).
If connections.size() < n - 1, we can directly return -1.

One trick is that, if we have enough cables,
we don't need to worry about where we can get the cable from.

We only need to count the number of connected networks.
To connect two unconneccted networks, we need to set one cable.

The number of operations we need = the number of connected networks - 1
*/
public class NumberofOperationstoMakeNetworkConnected {

    public static void main(String[] args) {
        NumberofOperationstoMakeNetworkConnected n =  new NumberofOperationstoMakeNetworkConnected();
        int[][] connections={{0,1},{0,2},{1,2}};
        System.out.println(n.makeConnected(4,connections));
    }


    int[] parent;
    int find(int x) {
        return parent[x] == x ? x : find(parent[x]);
    }

    int makeConnected(int n,int[][] connections){
        int c = connections.length;
        if (n-1 > c) return -1;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < c; i++) {
            int x = find(connections[i][0]);
            int y = find(connections[i][1]);
            if (x != y) parent[y] = x;
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (parent[i] == i)
                ans++;

        return ans-1;

    }
}
