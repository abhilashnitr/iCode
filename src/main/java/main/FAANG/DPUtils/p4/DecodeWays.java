package main.FAANG.DPUtils.p4;

import java.util.HashMap;

public class DecodeWays {

    public static void main(String[] args) {

        DecodeWays d=new DecodeWays();
        String s="12";
        System.out.println(d.numDecodings(s));
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        return numDecodings(s,s.length());
    }
    public int numDecodings(String s,int index){

        if(index==0||index==1)
            return 1;
        if(index<0)
            return 0;
        int res=0;
        if(s.charAt(index-1)>'0')
            res+=numDecodings(s,index-1);

        if(s.charAt(index-2)=='1'||(s.charAt(index-2)=='2'&& s.charAt(index-1)<'7'))
            res+=numDecodings(s,index-2);

        return res;
    }

    public int numDecodingsWithMemo(String s) {
        if(s.charAt(0)=='0')
            return 0;
        return numDecodingsMemo(s,s.length(),new HashMap<>());
    }
    public int numDecodingsMemo(String s,int index,HashMap<Integer,Integer> map){

        if(index==0||index==1)
            return 1;
        if(index<0)
            return 0;
        int res=0;
        if(map.containsKey(index))
            return map.get(index);
        if(s.charAt(index-1)>'0')
            res+=numDecodingsMemo(s,index-1,map);

        if(s.charAt(index-2)=='1'||(s.charAt(index-2)=='2'&& s.charAt(index-1)<'7'))
            res+=numDecodingsMemo(s,index-2,map);

        map.put(index,res);
        return res;
    }

    public int numDecodingsWithDp(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)>'0')
                dp[i]+=dp[i-1];
            if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&& s.charAt(i-1)<'7'))
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }

}
