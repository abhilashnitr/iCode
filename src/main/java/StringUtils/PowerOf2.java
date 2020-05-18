package StringUtils;

public class PowerOf2 {

  public static void main(String[] args) {
    int[] x={2,4,5,12,8,16,24,32};
    for(int i=0;i<x.length;i++){
      System.out.println(x[i]+" "+isPowerOf2(x[i]));
    }

  }

  private static boolean isPowerOf2(int x) {
    if(x==0)
      return false;

    while(x!=1){
      if(x%2!=0)
        return false;
      x=x/2;
    }
    return true;

  }

}
