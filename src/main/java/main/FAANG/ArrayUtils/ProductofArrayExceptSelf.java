package main.FAANG.ArrayUtils;

//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//Note: Please solve it without division and in O(n).
public class ProductofArrayExceptSelf {

    //maitain left product ad rightproduct
    //4   5   1    8   2
    //1   4   20   20  160  left prod
    //80  16  16   2   1    right prod
    //80  64  320  40  160  ans

    public int[] productExceptSelf(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
    //Time and space-O(N)

    //O(1) space
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
