package ArrayUtils;

public class SubArrayWithProdLessThanK {

  public static void main(String[] args) {
    int[] x={10,5,2,6};
    int k=100;

    countSubArray(x,k);
  }

  private static int countSubArray(int[] x, int k) {
    if(k<1)
      return 0;
    int prod=1;
    int left=0;
    int result=0;
    int right=0;
    while(right<x.length){
      prod=prod*x[right];
      if(prod >= k){
        prod /= x[left];
        left++;
      }
      result += right-left +1;

      right++;
    }
    System.out.println(result);
    return result;
  }

}
