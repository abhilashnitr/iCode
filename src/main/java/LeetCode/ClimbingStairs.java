package LeetCode;

public class ClimbingStairs {

  public int climbStairs(int n) {
    if(n==0||n==1)
      return n;
    int[] step=new int[n+1];
    step[0]=1;
    step[1]=1;
    for(int i=2;i<=n;i++){
      step[i]=step[i-1]+step[i-2];
    }
    return step[n];
  }

}
