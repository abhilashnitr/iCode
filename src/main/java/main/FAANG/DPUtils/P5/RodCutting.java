package main.FAANG.DPUtils.P5;

public class RodCutting {

    public static void main (String[] args) {
        int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // rod length
        int n = 4;
        System.out.println("Profit is " + rodCut(price, n));
        System.out.println("Profit is " + rodCutDP(price, n));
    }

    private static int rodCut (int[] price, int n) {

        if(n<=0)
            return 0;

        int maxValue = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxValue=Math.max(maxValue,rodCut(price,n-i-1)+price[i]);
        }

        return maxValue;
    }

    private static int rodCutDP (int[] price, int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int max= Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                max=Math.max(max,price[j]+dp[i-j-1]);
            }
            dp[i]=max;
        }
        return dp[n];
    }

}
