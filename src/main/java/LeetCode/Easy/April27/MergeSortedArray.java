package LeetCode.Easy.April27;

public class MergeSortedArray {
  public static void main(String[] args) {
    int mPlusN[] = {200, 800,0,0,0,0,0,0};
    int N[] = {5, 7, 9, 25,29,30};
    int n = N.length;
    int m = mPlusN.length-n;

    merge(mPlusN,m,N,n);

  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = m-- + n-- - 1;
    while (m >= 0 && n >= 0) {
      nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
    }

    while (n >= 0) {
      nums1[n] = nums2[n--];
    }
  }


}
