package main.FAANG.TwoPointers;

public class LC28 {

    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0)
            return 0;
        if(haystack==null || haystack.length()<needle.length())
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j;
            for( j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(needle.length()==j)
                return i;

        }

        return -1;
    }
}
