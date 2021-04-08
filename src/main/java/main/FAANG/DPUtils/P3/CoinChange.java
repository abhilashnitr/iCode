package main.FAANG.DPUtils.P3;

import main.SystemDesigns.VendingMachine.Coin;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount=11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins,amount));
        System.out.println(coinChange.coinChangeWithRec(coins,amount,new HashMap<>()));
        System.out.println(coinChange.coinChangeWithDp(coins,amount));


    }
    public int coinChange(int[] coins, int amount){

        return helper(coins,amount);
    }

    private int helper(int[] coins, int amount) {
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(amount==0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int c: coins)
        {
            int res = helper(coins, amount- c);
            if (res != Integer.MAX_VALUE) {
                min = Integer.min(min, res + 1);
            }
        }
        return min;
    }

    public int coinChangeWithRec(int[] coins, int amount, Map<Integer,Integer> map){

        return helper2(coins,amount,map);
    }

    private int helper2(int[] coins, int amount, Map<Integer, Integer> map) {
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(amount==0)
            return 0;
        int min = Integer.MAX_VALUE;
        if(map.containsKey(amount))
            return map.get(amount);
        for (int c: coins)
        {
            int res = helper(coins, amount- c);
            if (res != Integer.MAX_VALUE) {
                min = Integer.min(min, res + 1);
            }
        }
        map.put(amount,min);
        return min;
    }

    private static int coinChangeWithDp (int[] coins, int amount) {
        int[] dp=new int[amount+1];

        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            int res=Integer.MAX_VALUE;
            for(int c:coins){
                if(i-c>=0)
                    res=dp[i-c];
                if(res!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],res+1);

            }
        }
        return dp[amount];
    }

}
