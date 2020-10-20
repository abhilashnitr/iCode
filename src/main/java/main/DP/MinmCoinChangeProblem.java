package main.Practise.DP;

import java.util.HashMap;
import java.util.Map;

public class MinmCoinChangeProblem {

  public static void main (String[] args) {
    int[] S = { 1, 3, 5, 7 };

    // Total Change required
    int N = 18;
    Map<Integer, Integer> map = new HashMap<>();
    System.out.println("Minimum number of coins required to get desired change is "
        + findMinCoins(S, N));
    System.out.println("Minimum number of coins required to get desired change is "
        + findMinCoinsDp(S, N));
    System.out.println("Minimum number of coins required to get desired change is "
        + findMinCoinsDpLoopUp(S, N,map));
  }

  private static int findMinCoins (int[] s, int n) {
    if(n<0){
      return Integer.MAX_VALUE;
    }
    if(n==0)
      return 0;
    int coins = Integer.MAX_VALUE;
    for (int c: s)
    {
      int res = findMinCoins(s, n- c);
      if (res != Integer.MAX_VALUE) {
        coins = Integer.min(coins, res + 1);
      }
    }
    return coins;
  }

  private static int findMinCoinsDp (int[] s, int n) {
    int[] Coins=new int[n+1];

    for(int i=1;i<=n;i++){
      Coins[i]=Integer.MAX_VALUE;
      int res=Integer.MAX_VALUE;
      for(int c:s){
          if(i-c>=0)
            res=Coins[i-c];
          if(res!=Integer.MAX_VALUE)
            Coins[i]=Math.min(Coins[i],res+1);

      }
    }
    return Coins[n];
  }

  private static int findMinCoinsDpLoopUp (int[] coins, int total,Map<Integer, Integer> map){
    if ( total == 0 ) {
      return 0;
    }
    if ( map.containsKey(total) ) {
      return map.get(total);
    }
    int min = Integer.MAX_VALUE;
    for ( int i=0; i < coins.length; i++ ) {
      if( coins[i] > total ) {
        continue;
      }
      int val = findMinCoinsDpLoopUp(coins,total-coins[i], map);
      if( val < min ) {
        min = val;
      }
    }
    min =  (min == Integer.MAX_VALUE ? min : min + 1);
    map.put(total, min);
    return min;
  }


}
