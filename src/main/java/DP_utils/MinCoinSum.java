package DP_utils;

import java.util.HashMap;
import java.util.Map;

public class MinCoinSum {

    public static void main(String[] args) {
        Map<Integer, Integer> map=new HashMap<>();
        int[] coin={1,2,3,7};
        int sum=9;

        System.out.println(minCoinSum(map,coin,sum));
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
