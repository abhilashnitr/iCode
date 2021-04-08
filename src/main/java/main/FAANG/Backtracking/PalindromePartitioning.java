package main.FAANG.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        if(s==null || s.length()==0)
            return new ArrayList<>();

        List<List<String>> result=new ArrayList<>();
        helper(result,new ArrayList<>(), s);
        return result;
    }
    public void helper (List<List<String>> result,ArrayList<String> currentList,String temp)
    {
        if(temp==null || temp.length()==0){
            result.add(new ArrayList(currentList));
            return;
        }
        for(int i=1;i<=temp.length();i++){
            String leftString=temp.substring(0, i);
            if(!isPalindrome(leftString))
                continue;
            currentList.add(leftString);
            helper(result,currentList, temp.substring(i, temp.length()));
            currentList.remove(currentList.size()-1);
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
