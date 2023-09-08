package main.FAANG.GraphUtils;

import java.util.Arrays;

/*
In a social group, there are N people, with unique integer ids from 0 to N-1.
We have a list of logs, where each logs[i] = [timestamp, id_A, id_B]
contains a non-negative integer timestamp, and the ids of two different people.
Each log represents the time in which two different people became friends.
Friendship is symmetric: if A is friends with B, then B is friends with A.
Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.
Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such earliest time.
*/
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    /*
sort timestamp in increasing order.
union element who has same parent.
when there is only one parent, done.

Runtime: O(n log n) as we need to sort the input. Union-Find is O(n).
We use path compressoin and rank (wich is set size), so Union-Find is
O(n α(n)). α(n) can be considered O(1) for all practical purposes.
Memory: O(n) for the disjoint set.

//Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
//Output: 20190301
//Explanation:
//The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
//The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
//The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
//The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
//The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
//The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.

    */

    public class UF{
        int[] parent;
        int res;
        UF(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++)
                parent[i] = i;
            res = size;
        }
        public int find(int child){
            if(parent[child] != child){
                int p = find(parent[child]); //find parent recursively
                parent[child] = p;//update child's parent
            }

            return parent[child];
        }
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb){
                parent[pb] = pa;
                res--;//when union happens, we decrement one parent
            }

        }
    }
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        UF uf = new UF(N);
        for(int[] log : logs){
            uf.union(log[1], log[2]);
            if(uf.res == 1)
                return log[0];
        }
        return -1;
    }
}
