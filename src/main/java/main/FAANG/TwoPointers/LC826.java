package main.FAANG.TwoPointers;


import java.util.*;

//Most Profit Assigning Work
public class LC826 {
    //We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
    //
    //Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
    //
    //Every worker can be assigned at most one job, but one job can be completed multiple times.
    //
    //For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
    //
    //What is the most profit we can make?
    //Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
    //Output: 100
    //Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.

    public static void main(String[] args) {
        int[] diff={2,4,6,8,10};
        int[] profit={10,20,30,40,50};
        int[] worker={4,5,6,7};
        LC826 lc826=new LC826();
        System.out.println(lc826.maxProfitAssignmentWithDp(diff,profit,worker));

    }

//    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
//        int N = profit.length, res = 0, i = 0, best = 0;
//        for (int j = 0; j < N; ++j)
//            jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
//        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
//        Arrays.sort(worker);
//        for (int ability : worker) {
//            while (i < N && ability >= jobs.get(i).getKey())
//                best = Math.max(jobs.get(i++).getValue(), best);
//            res += best;
//        }
//        return res;
//    }

    public int maxProfitAssignmentWithDp(int[] difficulty, int[] profit, int[] worker) {
        int[] dp = new int[20];
        for (int i = 0; i < difficulty.length; i++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
        }
        int sum = 0;
        for (int i : worker) {
            sum += dp[i];
        }
        return sum;
    }
}
