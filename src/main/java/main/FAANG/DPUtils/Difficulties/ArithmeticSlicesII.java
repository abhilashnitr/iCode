package main.FAANG.DPUtils.Difficulties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesII {


    public static void main(String[] args) {
        int[] a={2,4,6,8,10};
        ArithmeticSlicesII arithmeticSlicesII=new ArithmeticSlicesII();
        System.out.println(arithmeticSlicesII.numberOfArithmeticSlices(a));
    }

    //Base case: T(0, d) = 0 (This is true for any d).
    //Recurrence relation: T(i, d) = summation of (1 + T(j, d)) as long as 0 <= j < i && d == A[i] - A[j].
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey((long)A[i])) {
                map.put((long)A[i], new ArrayList<>());
            }
            map.get((long)A[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long)A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k: map.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
