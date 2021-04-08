package main.FAANG.ArrayUtils;

//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//You can assume that you can always reach the last index.
public class JumpGameII {

    //The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
    //
    public int jump(int[] A) {
    	int jumps = 0, curEnd = 0, curFarthest = 0;
    	for (int i = 0; i < A.length - 1; i++) {
    		curFarthest = Math.max(curFarthest, i + A[i]);
    		//to reach curFarthest u need one step
    		if (i == curEnd) {
    			jumps++;
    			curEnd = curFarthest;
    		}
    	}
    	return jumps;
    }
}
