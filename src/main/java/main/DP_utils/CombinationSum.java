package main.DP_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
            int[] arr={10,1,2,7,6,1,5};
           Arrays.sort(arr);
            int sum=8;
            comninationSumUtil(arr,sum);
    }

    private static void comninationSumUtil(int[] arr, int sum) {

        ArrayList<Integer> result= new ArrayList<>();
        List<ArrayList<Integer>> resultList= new ArrayList<>();
        comninationSumUtil(arr,sum,result,resultList,0);
        System.out.println(resultList);
    }

    private static void comninationSumUtil(int[] arr, int sum, ArrayList<Integer> result, List<ArrayList<Integer>> resultList, int startindex) {
        if(sum==0){
            if(!resultList.contains(result))
            resultList.add(new ArrayList<>(result));
        }
        if(startindex==arr.length)
            return;
        for(int i=startindex;i<arr.length;i++){
            if(arr[i]>sum)
                continue;
            result.add(arr[i]);
            comninationSumUtil(arr,sum-arr[i],result,resultList,i+1);
            result.remove(result.size()-1);
        }

    }
}
