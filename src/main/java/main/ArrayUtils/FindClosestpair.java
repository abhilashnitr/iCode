package main.ArrayUtils;

public class FindClosestpair {

    public static void getPair(int[] x,int sum){
        int l=0;
        int h=x.length-1;
        int diff= Integer.MAX_VALUE;
        int res1=0;
        int res2=0;
        while (l<h){
            if(Math.abs(x[l]+x[h]-sum)<diff){
                diff= Math.abs(x[l]+x[h]-sum);
                res1=x[l];
                res2=x[h];
            }
            if(x[l]+x[h]>sum){
                h--;
            }
            else{
                l++;
            }
        }
        System.out.println("The Pairs are "+res1+"  "+res2);
    }
    public static void main(String[] args) {
        int[] x={2,5,6,11,26,28,30};

        getPair(x,17);


    }
}
