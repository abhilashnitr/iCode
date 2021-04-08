package main.FAANG.ArrayUtils;

//Given an array, rotate the array to the right by k steps, where k is non-negative.
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]

public class RotateArray {
    public void rotate(int[] A, int k) {

        int n= A.length;
        if(n==0||n==1)
            return;
        k=k%n;
        reverse(A, n - k, n - 1);

        // Reverse the first 'n-k' elements
        reverse(A, 0, n - k - 1);

        // Reverse the whole array
        reverse(A, 0, n - 1);
    }

    void reverse(int[] A, int low, int high)
    {
        for (int i = low, j = high; i < j; i++, j--) {
            swap(A, i, j);
        }
    }
    public  void swap(int[] A, int i, int j)
    {
        int data = A[i];
        A[i] = A[j];
        A[j] = data;
    }
}
