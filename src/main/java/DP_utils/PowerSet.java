package DP_utils;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] arr={1,2,3};
        powerSet(arr);
    }

    private static void powerSet(int[] arr) {
        ArrayList<Integer> result= new ArrayList<>();
        List<ArrayList<Integer>> resultList= new ArrayList<>();

        powerSetUtil(arr,result,resultList,0);
       // PowerSetUtil2(resultList,result,0,arr);
        System.out.println(resultList.size());
    }

    private static void powerSetUtil(int[] arr, ArrayList<Integer> result, List<ArrayList<Integer>> resultList,int StartIndex) {
        resultList.add(new ArrayList<>(result));
        System.out.println(result);
        if(StartIndex==arr.length)
            return;
        for(int i=StartIndex;i<arr.length;i++){
            result.add(arr[i]);
            powerSetUtil(arr,result,resultList,i+1);
            result.remove(result.size()-1);
        }
    }

    public static void PowerSetUtil2(int[] arr, ArrayList<Integer> result, List<ArrayList<Integer>> resultList,int StartIndex){
        resultList.add(new ArrayList<>(result));
        System.out.println(result);
        if(StartIndex==arr.length)
            return;
        for(int i=StartIndex;i<arr.length;i++){
            result.add(arr[i]);
            PowerSetUtil2(arr,result,resultList,i+1);
            result.remove(result.size()-1);
        }
    }


}
