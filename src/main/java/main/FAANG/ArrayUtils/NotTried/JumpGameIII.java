package main.FAANG.ArrayUtils.NotTried;

//Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at
//index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

//Notice that you can not jump outside of the array at any time.
// Input: arr = [4,2,3,0,3,1,2], start = 5
//Output: true
//Explanation:
//All possible ways to reach at index 3 with value 0 are:
//index 5 -> index 4 -> index 1 -> index 3
//index 5 -> index 6 -> index 4 -> index 1 -> index 3
public class JumpGameIII {

    //part of BFS //DFS so skipping it  now

    public boolean canReach(int[] arr, int st) {
        if (st >= 0 && st < arr.length && arr[st] < arr.length) {
            int jump = arr[st];
            arr[st] += arr.length;    // avoid duplicate path recursion
            return jump == 0 || canReach(arr, st + jump) || canReach(arr, st - jump);
        }
        return false;
    }

    //Complexity Analysis

    //Time: O(n); we mark elements as visited and do not process them again.
    //Memory: O(n) for the recursion.

}
