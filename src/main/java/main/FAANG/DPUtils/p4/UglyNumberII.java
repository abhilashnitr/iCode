package main.FAANG.DPUtils.p4;

import main.DP_utils.UglyNumber;

import java.util.PriorityQueue;

public class UglyNumberII {


    public static void main(String[] args) {
        UglyNumberII ug=new UglyNumberII();
        System.out.println(ug.nthUglyNumber2(8));
    }

    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }

    int getNthUglyNo(int n)
    {
        int ugly[] = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for(int i = 1; i < n; i++)
        {
            next_ugly_no = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
                i2 = i2+1;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
                i3 = i3+1;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
                i5 = i5+1;
                next_multiple_of_5 = ugly[i5]*5;
            }
            System.out.print(ugly[i]+" ");
        } /*End of for loop (i=1; i<n; i++) */

        return next_ugly_no;
    }

    public int nthUglyNumber2(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            int p2Val = dp[p2] * 2;
            int p3Val = dp[p3] * 3;
            int p5Val = dp[p5] * 5;
            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));
            /*
                move the pointer(s) that produced the currentUglyNumber
                so we don't consider that value again
            */
            if (currentUglyNumber == p2Val) p2++;
            if (currentUglyNumber == p3Val) p3++;
            if (currentUglyNumber == p5Val) p5++;
            dp[i] = currentUglyNumber;
        }
        return dp[n - 1];
    }

}
