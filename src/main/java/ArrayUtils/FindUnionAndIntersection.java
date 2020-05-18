package ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUnionAndIntersection {

  public static void main(String[] args) {
    int arr1[] = {1, 2, 4, 5, 5, 6};
    int arr2[] = {2, 2, 3 , 3 , 5, 7};
    int m = arr1.length;
    int n = arr2.length;
    printUnion(arr1, arr2, m, n);
  }

  public int[] intersection2(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> l = new ArrayList<Integer>();
    int i=0,j=0;
    while(i<nums1.length & j<nums2.length){
      if(nums1[i]==nums2[j]){
        if(i==0 | j==0){l.add(nums1[i]);} // do not check for duplicates
        else if(nums1[i]!=nums1[i-1]){l.add(nums1[i]);} // check for duplicates
        i++;
        j++;
      }
      else if(nums1[i]>nums2[j]){
        while(!(nums2[j]>=nums1[i])){
          j++;
          if(j==nums2.length){break;}
        }
      }
      else{
        while(!(nums1[i]>=nums2[j]))
        {
          i++;
          if(i==nums1.length){break;}
        }
      }
    }
    int[] res = new int[l.size()];
    for(int k =0; k<res.length; k++){
      res[k] = l.get(k);
    }
    return res;
  }
  public static int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> res = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    for (int num : nums1) {
      hs.add(num);
    }
    for (int num : nums2) {
      if (hs.contains(num)) {
        res.add(num);
        hs.remove(num);
      }
    }
    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      result[i] = res.get(i);
    }
    return result;
  }

  private static void printUnion(int[] arr1, int[] arr2, int m, int n) {
    int i = 0, j = 0;
    while (i < m && j < n)
    {
      if (arr1[i] < arr2[j]) {
        if(i==0 || arr1[i]!=arr1[i-1])
        System.out.print(arr1[i++] + " ");
        else
          i++;
      }
      else if (arr2[j] < arr1[i]) {
        if(j==0 || arr2[j]!=arr2[j-1])
        System.out.print(arr2[j++] + " ");
        else
          j++;
      }
      else
      {
        if(j==0|| arr2[j]!=arr2[j-1]) {
          System.out.print(arr2[j++] + " ");
          i++;
        }else {
          j++;
        }
      }
    }

      /* Print remaining elements of
         the larger array */
    while(i < m)
      System.out.print(arr1[i++]+" ");
    while(j < n)
      System.out.print(arr2[j++]+" ");

  }

}
