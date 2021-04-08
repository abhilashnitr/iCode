package main.FAANG.TwoPointers;
//Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
public class LC125 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            else if (!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            else {
                if (!(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))))
                    return false;
                i++;
                j--;
            }
        }

        return true;
    }
    }
