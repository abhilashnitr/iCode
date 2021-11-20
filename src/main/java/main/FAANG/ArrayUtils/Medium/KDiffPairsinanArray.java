package main.FAANG.ArrayUtils.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
//A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//
//0 <= i, j < nums.length
//i != j
//|nums[i] - nums[j]| == k
//Notice that |val| denotes the absolute value of val.
public class KDiffPairsinanArray {

    public static void main(String[] args) {
        int[] a={3,3,1,4,1,5};
        System.out.println(findPairs(a,2));

    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int findPairsWithTwoPoiters(int[] arr, int k) {

        int count = 0;
        Arrays.sort(arr); // Sort array elements
        int n=arr.length;
        int l = 0;
        int r = 1;
        while(r < n)
        {
            int diff=arr[r] - arr[l];
            if(l==r)
                r++;
            else if(diff == k)
            {
                count++;
                l++;
                r++;
            }
            else if(diff > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }

    public int findPairsWithDup(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1, count = 0;
        while(j < nums.length){
            if( i == j){
                j++;
            }
            if(j >= nums.length) break;
            while(i < j-1 && nums[i] == nums[i+1]) i++;
            while(j < nums.length -1 && nums[j] == nums[j+1]) j++;
            int dif = Math.abs(nums[i] - nums[j]);
            if(dif == k){
                count++; i++; j++;
            }
            else if(dif < k) j++;
            else i++;
        }
        return count;
    }


    public int findPairs4(int[] a, int k) {
        if(a.length <= 1) return 0;

        Arrays.sort(a);
        int start = 0;
        int end = 0;
        int pairCount = 0;

        while(start < a.length && end < a.length) {
            if(start == end || a[start] + k > a[end]) end++;
            else if(a[start] + k < a[end]) start++;
            else {
                pairCount++;
                start++;
                while(end < a.length - 1 && a[end] == a[end + 1]) end++;
                end++;
            }
        }
        return pairCount;
    }
}
