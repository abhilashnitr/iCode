package main.FAANG.SlidingWindow.AtMostOrPreSum;

//In an array A of 0s and 1s, how many non-empty subarrays have sum S?
//Input: A = [1,0,1,0,1], S = 2
//Output: 4
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        BinarySubarraysWithSum s=new BinarySubarraysWithSum();
        int[] a={1,0,1,0,1};
        System.out.println(s.numSubarraysWithSum2(a,2));
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

    //
    public int numSubarraysWithSum3(int[] A, int S) {
        int n = A.length;
        int left = 0, right = 0;
        int count = 0, sum = 0;
        for (; right < n; right++) {
            sum += A[right];
            while (left < right && sum > S) {
                sum -= A[left++];
            }
            if (sum == S) count++;
            for (int i = left; sum == S && i < right && A[i] == 0; i++)
                count++;
        }

        return count;
    }


    //https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186647/Java-Clean-Solution-2-Sum-%2B-Prefix-Sum-Caching

    public int numSubarraysWithSum4(int[] A, int target) {
        //The largest sum we can have is len(A) = n Why? What if array A[] has all 1's.
        int n = A.length;
        //Everything is initialized to zero
        int[] presum = new int[n+1];
        int sum = 0;
        //Case where it's just it's own
        int total = 0;

        for (int i = 0; i < A.length; i++){
            sum += A[i];
            int compliment = sum - target;

            if (compliment >= 0)
                total += presum[compliment];

            if (sum == target) total++;
            //Also put this sum into the map as well
            presum[sum]+=1;
        }

        return total;

    }
}
