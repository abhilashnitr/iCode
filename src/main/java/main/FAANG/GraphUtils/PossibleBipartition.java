package main.FAANG.GraphUtils;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.
*/
public class PossibleBipartition {
    public static void main(String[] args) {

        int n=4;
        int[][] dislikes={{1,2},{1,3},{2,4}};
        PossibleBipartition possibleBipartition=new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(n,dislikes));
    }

    List<Integer> [] disList;
    int[] color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // For each person, create a list of the people he/she dislikes
        disList = new List[N+1];
        for (int i = 1; i<=N ; i++)
            disList[i] = new ArrayList<Integer>();

        // iterate over dislikes[][], add one vertex to the other vertex's list
        // We need to add this edge twice due to the possibility of non-forest edges
        for (int[] edge : dislikes){
            disList[edge[0]].add(edge[1]);
            disList[edge[1]].add(edge[0]);
        }

        // create an array that stores the color of each vertex
        // two colors -1 & 1
        color = new int[N+1];

        // paint the vertices of the graph, start by assigning the first person a random color
        // use dfs, when an element isn't colored, we can randomly assign a color
        for (int person = 1; person <= N; person++){
            // color using dfs, return false if color conflicts arise during dfs
            // only color if the current element is not painted yet,otherwise, it has already been dfs checked
            if (color[person] == 0 && !dfs(person, -1))
                return false;
        }

        // the graph can be colored bipartitely
        return true;
    }

    private boolean dfs(int person, int color){
        // if person isn't painted yet
        if (this.color[person] == 0){
            // paint person with the specified color
            this.color[person] = color;

            int childColor = color == 1 ? -1 : 1;
            // dfs: paint its children - i.e the list of people it dislikes
            for ( int child : disList[person] ){
                // if color conflict arises during child's dfs
                if ( !dfs(child, childColor) )
                    return false;
            }
            // person is painted
        }else{
            // current color conflicts with the color passed in
            if ( this.color[person] != color)
                return false;
        }

        // no conflict during dfs
        return true;
    }

    /*
Time Complexity: O(N + E)O(N+E), where EE is the length of dislikes.

Space Complexity: O(N + E)O(N+E).
    */
}
