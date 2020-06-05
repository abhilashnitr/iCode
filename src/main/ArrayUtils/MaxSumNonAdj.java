package main.ArrayUtils;

public class MaxSumNonAdj {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,1,5,7,8,10};
        System.out.println(FindMaxSum(arr, arr.length));

    }
   static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
