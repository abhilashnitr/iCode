package main.FAANG.DPUtils.Difficulties;

import java.util.Arrays;
import java.util.Comparator;

//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an
// envelope.
//One envelope can fit into another if and only if both the width and height of one envelope are greater than the other
// envelope's width and height.
//Return the maximum number of envelopes you can Russian doll
public class RussianDollEnvelopes {

    //Sort the array. Ascend on width and descend on height if width are same.
    //Find the longest increasing subsequence based on height.
    //Since the width is increasing, we only need to consider height.
    //[3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as
    // an increasing number if the order is [3, 3], [3, 4]

    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
        });

        int   n  = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

}
