package main.ArrayUtils;

public class MergeNintoMPlusN {

  public static void main(String[] args) {
    int mPlusN[] = {2, 8,13,15, 20,0,0,0,0};
    int N[] = {5, 7, 9, 25};
    int n = N.length;
    int m = mPlusN.length-n;

    //merge(mPlusN,N,m,n);
    merge(mPlusN,m,N,n);
    printArray(mPlusN,m+n);
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

  private static void merge(int[] mPlusN, int[] N, int m, int n) {

    int i=m+n-1;
    int j=m+n-1;
    while(i>=0){
      if(mPlusN[i]!=-1){
        mPlusN[j]=mPlusN[i];
        j--;
      }
      i--;
    }
    int k=0;
    i=n;
    j=0;
    while(k<(m+n)){
      if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n))
      {
        mPlusN[k] = mPlusN[i];
        k++;
        i++;
      }
      else // Otherwise take element from N[]
      {
        mPlusN[k] = N[j];
        k++;
        j++;
      }
    }

  }

  private static void printArray(int arr[], int size)
  {
    int i;
    for (i = 0; i < size; i++)
      System.out.print(arr[i] + " ");

    System.out.println("");
  }

}
