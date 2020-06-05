package main.ArrayUtils;

import java.util.HashSet;

public class MaxMinArrange {

    public static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        int max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }

    public static int nthMagicNo(int n){
        int pow=1;
        int ans=0;
        while(n != 0){
            pow*=5;
            if((int)(n&1)==1){
                ans+=pow;
                System.out.println(ans);

            }
            n=n/2;
        }
        return  ans;
    }

    static int nthMagicNo2(int n)
    {
        int pow = 1, answer = 0;

        // Go through every bit of n
        while (n != 0)
        {
            pow = pow*5;

            // If last bit of n is set
            if ((int)(n & 1) == 1)
                answer += pow;

            // proceed to next bit
            // or n = n/2
            n >>= 1;
        }
        return answer;
    }

    public static void removeDupl(int[] arr){

        HashSet<Integer> set=new HashSet<Integer>();

       /* for(int )*/
    }
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = arr.length;
        System.out.println(91/10+"  "+91%10);
        System.out.println(nthMagicNo(10));

       System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
