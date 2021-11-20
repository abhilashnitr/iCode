package main.FAANG.Sums;

import java.util.Arrays;

public class Sum_3_Closest {

    public static void main(String[] args) {
        int[] arr={-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));
     }
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0] + num[1] + num[num.length - 1];
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) { //duplocate check for i >0
                int lo = i+1, hi = num.length-1;
                int sum=0;
                while (lo < hi) {
                    sum = num[lo] + num[hi] + num[i];
                    if (sum < target) lo++;
                    else hi--;

                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
