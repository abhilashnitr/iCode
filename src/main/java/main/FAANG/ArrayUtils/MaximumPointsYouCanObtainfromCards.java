package main.FAANG.ArrayUtils;
//There are several cards arranged in a row, and each card has an associated number of points The points are given in
// the integer array cardPoints.
//
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//
//Your score is the sum of the points of the cards you have taken.
//
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
public class MaximumPointsYouCanObtainfromCards {
    //if we want to take k cards, we could :
    //
    //take k cards from left.
    //take k cards from right.
    //take n(n >=1) cards from left, and take (k-n) cards from right.
    //look at the above picture,
    //let i be the cards number took from left and let k =4.
    //if i = 0, then total_cardpoints(i) = total points of the last k cards.(in this case 1+ 7+10+11 ).
    //if i = 1, then total_cardpoints(1)= total_cardpoints (0) + point[0] - point[5] .
    //if i = 2, then total_cardpoints (2) = total_cardpoints (1) + point[1] - point[6] .

    public int maxScore(int[] cardPoints, int k) {
        int[] dp = new int[k + 1];
        //   this dp array stores the total points when taking i cards from left.
        //   since we could take 0 - k cards from left ,the length of the dp array would be k+1.

        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
            dp[0] += cardPoints[i];
        }
        int max_points = dp[0];

        for (int i = 1; i < k + 1; i++) {
            dp[i] = dp[i - 1] + cardPoints[i - 1] - cardPoints[cardPoints.length - k + i - 1];
            max_points = Math.max(max_points, dp[i]);
        }

        return max_points;
    }

    //"In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards."
    //
    //In extreme case, we can choose last k or first k elements;
    //In general case, we choose some from the left end and others from the right end;
    //From the above 2 steps, why not connecting the both ends and then forming a curcular array?
    //Traverse the 2k elements to find the maximum: from the kth from the last one-> ... -> the last -> first -> ...->
    // the kth element, this is a typical sliding window problem.

    public int maxScore2(int[] cardPoints, int k) {
        int res = 0, len = cardPoints.length;
        for (int start = len - k, i = start, win = 0; i < len + k; ++i) {
            win += cardPoints[i % len]; // accumulate the value of the sliding window.
            if (i - start >= k) { // Is the sliding window wider than k?
                win -= cardPoints[(i - k) % len]; // deduct the element from the left of the window.
            }
            res = Math.max(win, res); // update the maximum.
        }
        return res;
    }


    //improved version of above
    public int maxScore3(int[] cardPoints, int k) {
        int left=0,right=0;
        for(int i=cardPoints.length-1;i>=cardPoints.length-k;i--) {
            right+=cardPoints[i];
        }
        int result = right;
        int i=-1;
        int j=cardPoints.length-k-1;
        for(int m=1;m<=k;m++) {
            i++;j++;
            left+=cardPoints[i];
            right-=cardPoints[j];
            result = Math.max(result, left+right);
        }
        return result;
    }
}
