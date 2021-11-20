package main.FAANG.GraphUtils;

public class NumberofConnectedComponentsinanUndirectedGraph {

    public static void main(String[] args) {
        int nodes=5;
        int[][] edges={{0,1},{0,3}};

        NumberofConnectedComponentsinanUndirectedGraph n=new NumberofConnectedComponentsinanUndirectedGraph();
        System.out.println(n.countComponents(nodes,edges));
    }

    public int countComponents(int n,int[][] M) {
        int count = n;
        int[] root = new int[n];
        for(int i=0;i<n;i++){
            root[i] =i;
        }
        for(int[] edge:M){
            int rooti = findRoot(root,edge[0]);
            int rootj = findRoot(root,edge[1]);
            if(rooti!=rootj){
                root[rooti] = rootj;
                count--;
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
