package main.FAANG.TwoPointers;

//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find
// two lines, which, together with the x-axis forms a container, such that the container contains the most water.
//
//Notice that you may not slant the container.
public class LC11 {

    public int MaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right)
        {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) maxArea = area;

            if (height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }

//    For someone who is not clear on this question. It's not like
//"https://leetcode.com/problems/trapping-rain-water/ " Which is to
//get the total water for all the bars problem, It actually is to find
//the any 2 bars ai, aj, which hold most water together with x-axis.
//This post give a very good detail explanation as well.
//https://leetcode.com/discuss/37631/simple-and-clear-proof-explanation
}
