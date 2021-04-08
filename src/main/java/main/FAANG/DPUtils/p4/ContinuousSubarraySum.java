package main.FAANG.DPUtils.p4;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {


    public static void main(String[] args) {
        int[] arr={23,2,4,6,7};
        int k=6;

        ContinuousSubarraySum csm=new ContinuousSubarraySum();
        System.out.println(csm.checkSubarraySum(arr,k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer,Integer> hashmap = new HashMap<>();
        int result = 0;
        int sum = 0;
        hashmap.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            sum = sum+nums[i];
            int mod = sum%k;
            if(hashmap.containsKey(mod))
            {
                if(i-hashmap.get(mod)>=2)
                    return true;
            }
            else
                hashmap.put(mod,i);
        }
        return false;
    }
}
