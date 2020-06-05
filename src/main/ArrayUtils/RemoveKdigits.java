package main.ArrayUtils;
//https://medium.com/@saurav.agg19/remove-k-digits-8d5aa221751a
//https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack
//https://leetcode.com/problems/remove-k-digits/discuss/88660/A-greedy-method-using-stack-O(n)-time-and-O(n)-space
import java.util.Stack;

public class RemoveKdigits {

  public static void main (String[] args) {
    System.out.println(removekDigit("10",1));

  }

  public static String removekDigit(String digit,int k){
    int prev=digit.charAt(0)-'0';
    int[] result=new int[digit.length()-k];
    int j=0;
    for(int i=1;i<digit.length();i++){

      if(((k>0)&&prev>(digit.charAt(i)-'0'))){
        k--;
      }else{
        if(prev!='0')
        result[j]=prev;
        j++;
      }
      prev=digit.charAt(i)-'0';
    }
      if(digit.charAt(digit.length()-1)!='0')
      result[j]=digit.charAt(digit.length()-1)-'0';
    String ans="";
    int i=0;
    while(result[i]==0)
      i++;
    for(;i<result.length;i++){
      ans+=result[i];
    }
    return ans;
  }

  public String removeKdigits(String num, int k) {
    int len = num.length();
    //corner case
    if(k==len)
      return "0";

    Stack<Character> stack = new Stack<>();
    int i =0;
    while(i<num.length()){
      //whenever meet a digit which is less than the previous digit, discard the previous one
      while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
        stack.pop();
        k--;
      }
      stack.push(num.charAt(i));
      i++;
    }

    // corner case like "1111"
    while(k>0){
      stack.pop();
      k--;
    }

    //construct the number from the stack
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty())
      sb.append(stack.pop());
    sb.reverse();

    //remove all the 0 at the head
    while(sb.length()>1 && sb.charAt(0)=='0')
      sb.deleteCharAt(0);
    return sb.toString();
  }

}
