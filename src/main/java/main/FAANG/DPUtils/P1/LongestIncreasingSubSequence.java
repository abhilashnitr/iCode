package main.FAANG.DPUtils.P1;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main (String[] args) {
        int[] x={8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};

        System.out.println(getLIS(x));
        System.out.println(getMaxSumIS(x));
    }

    private static int getMaxSumIS (int[] x) {
        int[] MIS=new int[x.length];

        MIS[0]=x[0];
        for(int i=1;i<x.length;i++){
            for(int j=0;j<i;j++){
                if(x[j]<x[i]&&MIS[j]+x[i]>MIS[i]){
                    MIS[i]=MIS[j]+x[i];
                }
            }
        }
        return Arrays.stream(MIS).max().getAsInt();
    }

    private static int getLIS (int[] x) {

        int[] LIS=new int[x.length];

        LIS[0]=1;
        for(int i=1;i<x.length;i++){
            for(int j=0;j<i;j++){
                if(x[j]<x[i]&&LIS[j]+1>LIS[i]){
                    LIS[i]=LIS[j]+1;
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
    }
}
