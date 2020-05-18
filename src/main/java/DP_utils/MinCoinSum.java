package DP_utils;

import java.util.HashMap;
import java.util.Map;

public class MinCoinSum {

    public static void main(String[] args) {
        Map<Integer, Integer> map=new HashMap<>();
        int[] coin={1,2,3,7};
        int sum=9;

        System.out.println(minCoinSum(map,coin,sum));
        System.out.println(minimumCoinDp(9,coin));
    }

    private static int minimumCoinDp(int total,int[] coins){
        int T[] = new int[total+1];
        int R[] = new int[total+1];
        T[0]=0;
        for (int i=1;i<=total;i++)
        {
            T[i]=Integer.MAX_VALUE;
            R[i]=-1;
        }
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<=total;i++){
                if(i>=coins[j]){
                    if(T[i]>1+T[i-coins[j]]){
                        T[i]=1+T[i-coins[j]];
                        R[i]=j;
                    }
                }
            }
        }
        printCoinCombination(R,coins);
        return T[total];
    }

    private static void printCoinCombination (int[] R, int[] coins) {

        if(R[R.length-1] == -1){
            System.out.println("No Solution");
            return;
        }
        int start=R.length-1;
        System.out.println("Coins used To Form Total");
        while(start!=0){
            int j=R[start];
            System.out.print(coins[j]+" ");
            start=start-coins[j];
        }
        System.out.println();
    }

    private static int minCoinSum(Map<Integer, Integer> map, int[] coin, int sum) {
        if(sum==0)
            return 0;
        if(map.containsKey(sum))
            return map.get(sum);
        int min= Integer.MAX_VALUE;
        for(int i=0;i<coin.length;i++)
        {
            if(coin[i]>sum)
                continue;
            int val=minCoinSum(map,coin,sum-coin[i]);

            if(val<min)
                min=val;
        }
        min= (min== Integer.MAX_VALUE)?min:min+1;
        map.put(sum,min);
        return min;
    }
}
