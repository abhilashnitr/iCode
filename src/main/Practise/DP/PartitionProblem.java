package main.Practise.DP;

import java.util.Arrays;

//Given a set of positive Integers,Find if it can be divided into two subsets with equal sum.
//s={3,1,1,2,2,1}
//3 1 1  and 2 2 1 or 1 1 1 2 and 3 2
public class PartitionProblem {

  public static void main (String[] args) {
    int[] A = { 7, 3, 1, 5, 4, 8 };

    System.out.println(partition(A));
    System.out.println(partitionDp(A));

  }
  public static boolean partition(int[] A) {
    int sum = Arrays.stream(A).sum();
    return (sum & 1) == 0 && subsetSum(A, A.length - 1, sum/2);
  }

  public static boolean subsetSum(int[] A, int n, int sum) {
    if (sum == 0) {
      return true;
    }
    if (n < 0 || sum < 0) {
      return false;
    }
    boolean include = subsetSum(A, n - 1, sum - A[n]);
    if(include)
      return true;
    boolean exclude = subsetSum(A, n - 1, sum );
    return exclude;
  }

  public static boolean partitionDp(int[] A) {
    int sum = Arrays.stream(A).sum();
    return (sum & 1) == 0 && subsetSumDp(A, A.length , sum/2);
  }

  private static boolean subsetSumDp (int[] a, int n, int sum) {
    boolean[][] T=new boolean[n+1][sum+1];

    for(int i=0;i<=n;i++){
      for(int j=0;j<=sum;j++){
        if(i==0||j==0)
          T[i][j]=true;
        else if(a[i-1]>j)
          T[i][j]=T[i-1][j];
        else
          T[i][j]=T[i-1][j]||T[i-1][j-a[i-1]];
      }
    }
    return T[n][sum];
  }

}
