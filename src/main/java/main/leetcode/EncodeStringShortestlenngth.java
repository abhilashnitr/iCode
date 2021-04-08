package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeStringShortestlenngth {

    Map<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) {
        EncodeStringShortestlenngth s=new EncodeStringShortestlenngth();
        int[] arr={23,2,4,6,7};

        System.out.println(s.checkSubarraySum(arr,6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }

    public String encode(String s) {
        int n = s.length();
        String[][] f = new String[n][n];
        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1;
                f[i][j] = s.substring(i, j + 1);
                for (int k = i; k < j; ++k) {
                    if (f[i][k].length() + f[k + 1][j].length() < f[i][j].length()) {
                        f[i][j] = f[i][k] + f[k + 1][j];
                    }
                }
                String now = s.substring(i, j + 1);
                int idx = (now + now).indexOf(now, 1);
                if (idx < now.length()) {
                    now = String.valueOf(now.length() / idx) + "[" + f[i][i + idx - 1] + "]";
                }
                if (now.length() < f[i][j].length()) {
                    f[i][j] = now;
                }
            }
        }
        return f[0][n - 1];
    }


    public String encode2(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() <= 4) return s;
        if (map.containsKey(s)) return map.get(s);
        String ret = s;
        for (int k = s.length() / 2; k < s.length(); k ++) {
            String pattern = s.substring(k);
            int times = countRepeat(s, pattern);
            if (times * pattern.length() != s.length()) continue;
            String candidate = Integer.toString(times) + "[" + encode(pattern) + "]";
            if (candidate.length() < ret.length()) ret = candidate;
        }
        for (int i = 1; i < s.length(); i ++) {
            String left = encode(s.substring(0, i));
            String right = encode(s.substring(i));
            String candidate = left + right;
            if (candidate.length() < ret.length()) ret = candidate;
        }
        map.put(s, ret);
        return ret;
    }

    private int countRepeat(String s, String pattern) {
        int times = 0;
        while (s.length() >= pattern.length()) {
            String sub = s.substring(s.length() - pattern.length());
            if (sub.equals(pattern)) {
                times ++;
                s = s.substring(0, s.length() - pattern.length());
            } else return times;
        }
        return times;
    }
}
