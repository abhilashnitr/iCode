package LeetCode.Easy.April27;

public class PlusOne {

  public static void main(String[] args) {
    int[] n1={9,9,9};
    int[] n2=plusOne(n1);
    for(int i=0;i<n2.length;i++){
      System.out.println(n2[i]);
    }
  }

  public static int[] plusOne(int[] digits) {
    //judge each in turn
    for(int i = digits.length - 1; i >= 0; i--) {
      if(digits[i] != 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }
    // we need to apply a new array to make length++
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }

}
