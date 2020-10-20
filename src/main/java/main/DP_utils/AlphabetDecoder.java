package main.DP_utils;

public class AlphabetDecoder {

    public static void main(String[] args) {
        char[] digit={'1','2','3','4'};
        System.out.println(getCountDecodicng(digit,digit.length));
        System.out.println(getCountDecodicngDP(digit,digit.length));
    }

    private static int getCountDecodicngDP(char[] digits, int length) {
        int[] count=new int[length+1];
        count[0]=1;
        count[1]=1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        for(int n=2;n<=length;n++){
            if(digits[n-1]>'0')
                count[n]=count[n-1];
            if(digits[n-2]=='1'||(digits[n-2]=='2'&&digits[n-1]<'7')){
                count[n]+=count[n-2];
            }
        }

        return count[length];
    }

    private static int getCountDecodicng(char[] digits, int n) {

        if (n == 0 || n == 1)
            return 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        int count = 0;
        if(digits[n-1]>'0')
            count=getCountDecodicng(digits,n-1);
        if(digits[n-2]=='1'||(digits[n-2]=='2'&&digits[n-1]<'7')){
            count+=getCountDecodicng(digits,n-2);
        }
        return count;
    }
}
