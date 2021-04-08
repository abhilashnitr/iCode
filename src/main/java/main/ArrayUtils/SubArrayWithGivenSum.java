package main.ArrayUtils;

import java.util.HashMap;

public class SubArrayWithGivenSum {
    static int[] arr={1,2,3,-5,9,8,-90,46};



    public static void getIndex(int[] x,int Sum){
        int CurSum=0;
        int i,j;
        for(i=0;i<x.length;i++){
            CurSum=x[i];
            for(j=i+1;j<x.length;j++){
                if(CurSum ==Sum){
                    int p=j-1;
                    System.out.println("Sum found between indexes1  "+i +" "+p);
                }
                if(CurSum>Sum)
                    break;
                CurSum+=x[j];
            }
        }
    }

    //Not For Negative Numbers
    public static void getIndex2(int[] x,int Sum){
            int CurSum=x[0];
            int i;
            int Start=0;
            for(i=1;i<x.length;i++) {
                while(CurSum>Sum && Start<i-1)
                {
                    CurSum-=x[Start];
                    Start++;
                }
                if(CurSum ==Sum){
                    int p=i-1;
                    System.out.println("Sum found between indexes2  "+Start +" "+p);
                }
                CurSum = x[i]+CurSum;
            }
    }

    public static void getIndex3(int[] x,int Sum){
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<x.length;i++){
            cur_sum=cur_sum+x[i];
            if(cur_sum==Sum){
                System.out.println("Sum found between indexes3  "+0 +" "+i);
            }
            if(hashMap.containsKey(cur_sum-Sum)){
                System.out.println("Sum found between indexes3  "+(hashMap.get(cur_sum-Sum)+1)+" "+i);
            }
            hashMap.put(cur_sum,i);
        }
    }
    public static void main(String[] args) {
        getIndex(arr,17);
        getIndex2(arr,17);
        getIndex3(arr,5);
    }
}
