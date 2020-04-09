package DP_utils;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
            int[] arr={1,2,3,4,5,7,8};
            int sum=5;
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
            resultList.add(new ArrayList<>(result));
        }
        if(startindex==arr.length)
            return;
        for(int i=startindex;i<arr.length;i++){
            if(arr[i]>sum)
                continue;
            result.add(arr[i]);
            comninationSumUtil(arr,sum-arr[i],result,resultList,i);
            result.remove(result.size()-1);
        }

    }
}
