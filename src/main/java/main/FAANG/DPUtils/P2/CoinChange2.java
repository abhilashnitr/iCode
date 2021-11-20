package main.FAANG.DPUtils.P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange2 {

    public static void main(String[] args) {
        CoinChange2 coinChange2=new CoinChange2();
        int[] coin={1,2,5};
        int target=2;
        System.out.println(coinChange2.change(target,coin));
        System.out.println(coinChange2.change2(target,coin));
        System.out.println(coinChange2.change3(target,coin));
        System.out.println(coinChange2.change4(target,coin));
        System.out.println(coinChange2.changeSimillartocombinationSum1(target,coin));

    }


    public int changeSimillartocombinationSum1(int amount, int[] coins) {

        Map<String,Integer> map =new HashMap<>();
        int res = backtrack( new ArrayList<>(), coins, amount, 0,map);
        return res;

    }

    private int backtrack(List<Integer> tempList, int [] nums, int remain, int start, Map<String,Integer> map){
        if(remain < 0) return 0;
        if(remain == 0) {
            System.out.println("list "+tempList);
            return 1;
        }
        int res=0;
        String encodeString = start + "->" + remain;
        if(map.containsKey(encodeString))
            return map.get(encodeString);
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            res+= backtrack(tempList, nums, remain - nums[i], i,map);
            // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
        map.put(encodeString,res);
        return res;

    }


    public int change(int amount, int[] coins) {
        return change(amount, 0, coins);
    }
    private int change(int balance, int cur, int[] coins) {
        if(balance == 0) return 1;

        if(balance<0 || cur == coins.length) return 0;
        return change(balance-coins[cur], cur, coins) + change(balance, cur+1, coins);
    }

    public int change2(int amount, int[] coins) {
        Integer[][] mem=new Integer[coins.length][amount+1];
        return change2(amount, 0, coins,mem);
    }
    private int change2(int amount, int cur, int[] coins, Integer[][] mem) {
        if(amount == 0) return 1;
        if(amount<0 || cur == coins.length) return 0;
        if(mem[cur][amount]!=null) return mem[cur][amount];
        return mem[cur][amount]=change2(amount-coins[cur], cur, coins,mem) + change2(amount, cur+1, coins,mem);
    }

    public int change3(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
//Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], then we can optimize the space by only using one-dimension array.
    public int change4(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
