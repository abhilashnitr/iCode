package ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class argestSubarrayWithEqualNumberOf0sAnd1s {

  public static void main(String[] args)
  {
    argestSubarrayWithEqualNumberOf0sAnd1s sub = new argestSubarrayWithEqualNumberOf0sAnd1s();
    int arr[] = { 1, 0, 0, 0, 1, 0 ,1 , 1 };
    int n = arr.length;

    sub.maxLen(arr, n);
    System.out.println(sub.findMaxLength(arr));
    sub.findMaxLength(arr);
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int maxlen = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 1 ? 1 : -1);
      if (map.containsKey(count)) {
        maxlen = Math.max(maxlen, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }
    return maxlen;
  }

  int maxLen(int arr[], int n)
  {
    HashMap<Integer, Integer> hM = new HashMap<>();
    int sum = 0; // Initialize sum of elements
    int max_len = 0; // Initialize result
    int ending_index = -1;
    int start_index = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == 0) ? -1 : 1;
    }

    for (int i = 0; i < n; i++) {
      // Add current element to sum
      sum += arr[i];
      // To handle sum=0 at last index
      if (sum == 0) {
        max_len = i + 1;
        ending_index = i;
      }
      // If this sum is seen before, then update max_len
      // if required
      if (hM.containsKey(sum )) {
        if (max_len < i - hM.get(sum )) {
          max_len = i - hM.get(sum );
          ending_index = i;
        }
      }
      else // Else put this sum in hash table
        hM.put(sum , i);
    }

    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == -1) ? 0 : 1;
    }

    int end = ending_index - max_len + 1;
    System.out.println(end + " to " + ending_index);

    return max_len;
  }


  int findSubArray(int arr[], int n)
  {
    int sum = 0;
    int maxsize = -1, startindex = 0;
    int endindex = 0;

    // Pick a starting point as i

    for (int i = 0; i < n - 1; i++) {
      sum = (arr[i] == 0) ? -1 : 1;

      // Consider all subarrays starting from i

      for (int j = i + 1; j < n; j++) {
        if (arr[j] == 0)
          sum += -1;
        else
          sum += 1;

        // If this is a 0 sum subarray, then
        // compare it with maximum size subarray
        // calculated so far

        if (sum == 0 && maxsize < j - i + 1) {
          maxsize = j - i + 1;
          startindex = i;
        }
      }
    }
    endindex = startindex + maxsize - 1;
    if (maxsize == -1)
      System.out.println("No such subarray");
    else
      System.out.println(startindex + " to " + endindex);

    return maxsize;
  }

}
