package main.StringUtils;

public class IntegerToRoman {

  /*
Suppose the input number is 3549. So, starting from thousand’s place we will start printing the roman equivalent. In this case we will print in the order as given below:
First: Roman equivalent of 3000
Second: Roman equivalent of 500
Third: Roman equivalent of 40
Fourth: Roman equivalent of 9
So, the output will be: MMMDXLIX
*/
  static String intToRoman(int num)
  {
    // storing roman values of digits from 0-9
    // when placed at different places
    String m[] = {"", "M", "MM", "MMM"};
    String c[] = {"", "C", "CC", "CCC", "CD", "D",
        "DC", "DCC", "DCCC", "CM"};
    String x[] = {"", "X", "XX", "XXX", "XL", "L",
        "LX", "LXX", "LXXX", "XC"};
    String i[] = {"", "I", "II", "III", "IV", "V",
        "VI", "VII", "VIII", "IX"};

    // Converting to roman
    String thousands = m[num/1000];
    String hundereds = c[(num%1000)/100];
    String tens = x[(num%100)/10];
    String ones = i[num%10];

    String ans = thousands + hundereds + tens + ones;

    return ans;
  }

}
