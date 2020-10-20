package main.ArrayUtils;

    //Given a non-negative integer, you could swap two digits at
    //most once to get the maximum valued number. Return the
    // maximum valued number you could get.
public class MaximumSwap {

  public static void main (String[] args) {
    MaximumSwap mx=new MaximumSwap();
    System.out.println(mx.maximumSwap(6738));
  }
  public int maximumSwap(int num) {
    char[] A = Integer.toString(num).toCharArray();
    int[] last = new int[10];
    for (int i = 0; i < A.length; i++) {
      last[A[i] - '0'] = i;
    }

    for (int i = 0; i < A.length; i++) {
      for (int d = 9; d > A[i] - '0'; d--) {
        if (last[d] > i) {
          char tmp = A[i];
          A[i] = A[last[d]];
          A[last[d]] = tmp;
          return Integer.valueOf(new String(A));
        }
      }
    }
    return num;
  }


}
