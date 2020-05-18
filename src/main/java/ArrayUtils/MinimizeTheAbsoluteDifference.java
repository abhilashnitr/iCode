package ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeTheAbsoluteDifference {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(7,9,15));
    ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2,3,6,6));

    System.out.println(solve(A,B,C));
  }

  public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    int i = 0, j = 0, k = 0;
    int ans = Integer.MAX_VALUE;

    int max, min;

    while(i < A.size() && j < B.size() && k < C.size()) {

      max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
      min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

      ans = Math.min(ans, max-min);
      if(ans == 0)
        break;

      if(A.get(i) == min)
        i++;
      else if(B.get(j) == min)
        j++;
      else
        k++;
    }

    return ans;
  }

}

/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and
minimum number from the triplet a, b, c such that a, b, c belongs
arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.
*/