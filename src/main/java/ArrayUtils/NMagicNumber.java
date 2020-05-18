package ArrayUtils;

public class NMagicNumber {

  public static void main(String[] args) {
    int n=5;
    printMagic(n);
  }

  private static void printMagic(int n) {
    int pow=1;
    int result = 0;
    while(n!=0){
      pow *=5;
      if((int)(n&1)==1)
        result+=pow;
      n=n>>1;
    }
    System.out.println(result);
  }

}
