package LeetCode.Easy.April27;

public class AddBinary {

  public String addBinary(String a, String b) {

    if(a == null || a.length() == 0){
      return b;
    }
    if(b == null || b.length() == 0){
      return a;
    }

    int i = a.length() - 1;
    int j = b.length() - 1;
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while(i >= 0 || j >= 0){
      int cur1 = 0, cur2 = 0;
      if(i >= 0){
        cur1 = a.charAt(i) - '0';
      }
      if(j >= 0){
        cur2 = b.charAt(j) - '0';
      }

      int sum = cur1 + cur2 + carry;
      int current = sum % 2;
      carry = sum / 2;

      sb.append(current);
      i--;
      j--;
    }

    if(carry != 0){
      sb.append(carry);
    }

    return sb.reverse().toString();

  }

}
