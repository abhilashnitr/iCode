package main.FAANG.ArrayUtils.Medium;

public class NextPermutation {

    // 53541
    // 54531
    // 54135

    public static void main(String[] args) {
        int[] a={3,2,1,3,6,4,3,2};
        NextPermutation nextPermutation=new NextPermutation();
        nextPermutation.nextPermutation(a);
        for(int i:a)
            System.out.print(i+" ");

    }

    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    //Reverse find first number which breaks descending order.
    //
    //Exchange this number with the least number that's greater than this number from the end.
    //
    //Reverse sort the numbers after the exchanged number.


    public void nextPermutation2(int[] nums) {
        int n = nums.length, k, l;
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k < 0) {
            reverse2(nums, 0, n - 1);
        } else {
            for (l = n - 1; l >= 0; l--) {
                if (nums[k] < nums[l]) {
                    break;
                }
            }
            swap2(nums, k, l);
            reverse2(nums, k + 1, n - 1);
        }
    }

    private void swap2(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse2(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
