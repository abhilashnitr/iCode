package main.DP_utils;


public class RodCutting {

    public static void main(String[] args) {
        //int[] length={1,2,3,4,5,6,7,8};
        int[] price={1,5,8,9,10,12,13,20};

        System.out.println(getMax(8,price));
        System.out.println(getMax2(8,price));

    }

    private static int getMax2(int n, int[] price) {
        int[] val=new int[n+1];
        val[0]=0;
        for(int i=1;i<=n;i++){
            int max= Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                max= Integer.max(max,price[j]+val[i-j-1]);
            }
            val[i]=max;
        }
        return val[n];
    }

    private static int getMax(int length, int[] price) {
        if(length<=0)
            return 0;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            max= Math.max(max,price[i]+getMax(length-i-1,price));
        }
        return max== Integer.MIN_VALUE?-1:max;
    }
}
