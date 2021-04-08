package main.FAANG.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int pre = map.get(nums[i]);
                if(i-pre<=k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums==null || nums.length<2 || k==0)
            return false;

        int i=0;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int j=0; j<nums.length; j++){
            if(!set.add(nums[j])){
                return true;
            }

            if(set.size()>=k+1){
                set.remove(nums[i++]);
            }
        }

        return false;
    }
}
