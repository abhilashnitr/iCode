package main.FAANG.SlidingWindow;

//In an array A of 0s and 1s, how many non-empty subarrays have sum S?
//Input: A = [1,0,1,0,1], S = 2
//Output: 4
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        BinarySubarraysWithSum s=new BinarySubarraysWithSum();
        int[] a={1,0,1,0,1};
        System.out.println(s.numSubarraysWithSum(a,2));
    }

//Count the occurrence of all prefix sum.
//I didn't notice that the array contains only 0 and 1,
//so this solution also works if have negatives.
    public int numSubarraysWithSum(int[] A, int S) {
        int psum = 0, res = 0, count[] = new int[A.length + 1];
        count[0] = 1;
        for (int i : A) {
            psum += i;
            if (psum >= S)
                res += count[psum - S];
            count[psum]++;
        }
        return res;
    }
    //Space O(N)
    //Time O(N)

    public int numSubarraysWithSum2(int[] A, int S) {
        // calculate all subarrays less and equal to sum S minus all subarrays less and equal to sum S - 1
        return atMost(A, S) - atMost(A, S - 1);
    }

    public int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            res += j - i + 1;
        }
        return res;
    }
    //Space O(1)
    //Time O(N)
}
