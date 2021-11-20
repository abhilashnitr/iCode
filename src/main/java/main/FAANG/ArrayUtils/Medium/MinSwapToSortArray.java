package main.FAANG.ArrayUtils.Medium;


//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/

public class MinSwapToSortArray {

  public static void main(String[] args) {

    //int[] arr = {2,4,5,1,3};
    int[] arr = {4,3,2,1};
    int res = minimumSwaps(arr);
    System.out.println(res);

  }

  static int minimumSwaps(int[] arr) {
    int swap = 0;
    boolean visited[] = new boolean[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int j = i, cycle = 0;


      while (!visited[j]) {
        visited[j] = true;
        j = arr[j] - 1;
        cycle++;
      }

      if (cycle != 0)
        swap += cycle - 1;
    }
    return swap;

  }

}
