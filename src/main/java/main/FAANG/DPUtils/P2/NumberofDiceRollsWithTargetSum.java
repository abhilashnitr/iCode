package main.FAANG.DPUtils.P2;

import java.util.HashMap;
import java.util.Map;

public class NumberofDiceRollsWithTargetSum {


    public static void main(String[] args) {
        NumberofDiceRollsWithTargetSum numberofDiceRollsWithTargetSum=new NumberofDiceRollsWithTargetSum();
        int x=numberofDiceRollsWithTargetSum.numRollsToTargetWithMemo(2,6,7,new int[2+1][7+1]);
        System.out.println(x);
    }
    public int numRollsToTarget(int d, int f, int target) {
        if(d==0&&target==0)
            return 1;
        else if(d==0||target==0)
            return 0;

        int res=0;
        for(int i=1;i<=f;i++) {
            if (target >= i)
                res += numRollsToTarget(d - 1, f, target - i);
            else
                break;
        }
        return res;
    }


    public int numRollsToTargetWithMemo(int d, int f, int target, int[][] memo) {
        if(d==0&&target==0)
            return 1;
        else if(d==0||target==0)
            return 0;

        if(memo[d][target]>0)
            return memo[d][target];

        int res=0;
        for(int i=1;i<=f;i++)
            if(target>=i)
                res+=numRollsToTarget(d-1,f,target-i);

        memo[d][target]=res;
        return res;

    }

    public int numRollsToTargetWithDp(int d, int f, int target) {
        if(d==0&&target==0)
            return 1;
        else if(d==0||target==0)
            return 0;

        int[][] dp=new int[d+1][target+1];

        for(int i=1;i<=d;i++){
            for(int j=0;j<=target;j++){
                for(int k=0;k<=f;k++){
                    if(j>=f){
                        dp[i][j]+=dp[i-1][j-k];
                    }
                    else
                        break;
                }
            }
        }
        return dp[d][target];

    }

}
