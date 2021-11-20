package main.FAANG.CompanySpecific;

//https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
public class MedianOfTwoSortedArrays {


    static int getMedian(int ar1[], int ar2[],
                         int n, int m)
    {
        // Current index of input array ar1[]
        int i = 0;

        // Current index of input array ar2[]
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

            for(count = 0; count <= (n + m) / 2; count++)
            {
                m2 = m1;
                if (i != n && j != m)
                {
                    m1 = (ar1[i] > ar2[j]) ?
                            ar2[j++] : ar1[i++];
                }
                else if (i < n)
                {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else
                {
                    m1 = ar2[j++];
                }
            }
            return   (m+n)%2==1?m1:(m1 + m2) / 2;
    }
    //Time O(n+m)  //Space O(1)

    //Better Solution:
    //https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // make sure m <= n
        if (m > n) return findMedianSortedArrays(B, A);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int A_left = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int A_right = i == m ? Integer.MAX_VALUE : A[i];
            int B_left = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int B_right = j == n ? Integer.MAX_VALUE : B[j];

            if (A_left > B_right) {
                imax = i - 1;
            } else if (B_left > A_right) {
                imin = i + 1;
            } else {
                int max_left = A_left > B_left ? A_left : B_left;
                int min_right = A_right > B_right ? B_right : A_right;
                if ((m + n) % 2 == 1)
                    return max_left; // # of left_part = # of right_part + 1;
                else
                    return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }

    //Time : O(log(min(m,n)))
    public static void main(String[] args) {
        int ar1[] = { 800,900 };
        int ar2[] = { 5, 8, 10, 20 };

        int n1 = ar1.length;
        int n2 = ar2.length;

        System.out.println(getMedian(ar1, ar2, n1, n2));
        System.out.println(findMedianSortedArrays(ar1,
                ar2));
    }
}


