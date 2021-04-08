package main.FAANG.ArrayUtils;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits={1,2,9};
        int[] arr=plusOne.plusOne(digits);
        for(int a:arr){
            System.out.print(a+" ");
        }

    }


    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }

        digits= new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
