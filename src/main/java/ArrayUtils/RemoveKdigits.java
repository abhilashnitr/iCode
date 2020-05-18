package ArrayUtils;

public class RemoveKdigits {

  public static void main (String[] args) {
    System.out.println("Hello Java");
    removekDigit("1432219",3);
  }

  public static String removekDigit(String digit,int k){
    int prev=digit.charAt(0)-'0';
    int[] result=new int[digit.length()-k];
    int j=0;
    for(int i=1;i<digit.length();i++){

      if(((k>0)&&prev>(digit.charAt(i)-'0'))){
        k--;
      }else{
        result[j]=prev;
        j++;
      }
      prev=digit.charAt(i)-'0';
    }

      result[j]=digit.charAt(digit.length()-1)-'0';
    String ans="";
    for(int i=0;i<result.length;i++){
      ans+=result[i];
    }
    return ans;
  }

}
