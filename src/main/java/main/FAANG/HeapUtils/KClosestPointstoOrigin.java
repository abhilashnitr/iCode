package main.FAANG.HeapUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
// k closest points to the origin (0, 0).
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        int[][] points={{3,3},{5,-1},{-2,4}};
        int k=2;
        KClosestPointstoOrigin kClosestPointstoOrigin=new KClosestPointstoOrigin();
        System.out.println(Arrays.toString(kClosestPointstoOrigin.kClosest(points,2)));
    }
    //MaxHeap
    public int[][] kClosest(int[][] points, int K) {

        Comparator<int[]> comparator= (o1, o2) -> o2[0]*o2[0]+o2[1]*o2[1] -
                o1[0]*o1[0]+o1[1]*o1[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
    //Theoretically, the time complexity is O(NlogK), but pratically, the real time it takes on leetcode is 134ms.
    //
    //The advantage of this solution is it can deal with real-time(online) stream data. It does not have to know the size of the data previously.
    //The disadvatage of this solution is it is not the most efficient solution.

    //we could have sort this array based on √(x1)2 + (y1)2 but and return the first k points
    // Theoretically, the time complexity is O(NlogN)
}
