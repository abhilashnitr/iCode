package main.FAANG.TwoPointers;

import java.util.*;

//350. Intersection of Two Arrays II
//Given two arrays, write a function to compute their intersection.
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
public class LC350 {
    public static void main(String[] args) {
        LC350 lc350=new LC350();
        int[] a1={1,2,2,1};
        int[] a2={2,2};
        int[] a=lc350.intersectionwithDup(a1,a2);
        for(int ar:a){
            System.out.print(ar+" ");
        }
    }

    public int[] intersectionwithDup(int[] nums1, int[] nums2) {
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }


}
