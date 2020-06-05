package main.DP_utils;

import static java.lang.Integer.max;

public class KnapSack {
    public static void main(String[] args) {
//        int[] val={60,100,120};
//        int[] weight={10,20,30};
//        int W=50;
        int[] val={20, 5, 10, 40, 15, 25};
        int[] weight={1, 2,  3,  8,  7, 4};
        int W=10;
        System.out.println(knapSackRec(weight,val,W,val.length));
        System.out.println(knapSack(W,weight,val,val.length));

    }

    private static int knapSack(int[] weight, int[] val, int w, int len) {
        int[][] T=new int[len+1][w+1];
        for(int i=0;i<=weight.length;i++){
            for(int j=0;j<=w;j++){
                if(i==0||j==0)
                    T[i][j]=0;
                else if(weight[i]>j)
                    T[i][j]=T[i-1][j];
                else
                    Math.max(T[i-1][j],
                            val[i-1]+T[i-1][j-weight[i-1]]);
            }
        }
        return T[len][w];
    }

//    static int knapSack(int W, int wt[], int val[], int n)
//    {
//        int i, w;
//        int K[][] = new int[n+1][W+1];
//        // Build table K[][] in bottom up manner
//        for (i = 0; i <= n; i++)
//        {
//            for (w = 0; w <= W; w++)
//            {
//                if (i==0 || w==0)
//                    K[i][w] = 0;
//                else if (wt[i-1] <= w)
//                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
//                else
//                    K[i][w] = K[i-1][w];
//            }
//        }
//        return K[n][W];
//    }
 static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }
    private static int knapSackRec(int[] weight, int[] val, int w, int length) {

        if(length==0||w==0)
            return 0;
        if(weight[length-1]>w)
             return knapSackRec(weight,val,w,length-1);
        else
            return Math.max(knapSackRec(weight,val,w,length-1),
                    val[length-1]+knapSackRec(weight,val,w-weight[length-1],length-1));
    }
}
