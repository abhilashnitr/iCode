package main.FAANG.SlidingWindow.stringRel;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString=new PermutationInString();
        System.out.println(permutationInString.checkInclusion2("ab","aibbaooo"));
    }

    public boolean checkInclusion2(String p, String s) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return false;
        int[] hash = new int[256]; //character hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            if (hash[s.charAt(right)] >= 1)
                count--;
            hash[s.charAt(right)]--;
            right++;


            if (count == 0) return true;


            if (right - left == p.length() )
            {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return false;
    }


    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            if(i - len1 >= 0) count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
