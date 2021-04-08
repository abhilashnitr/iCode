package main.FAANG.ArrayUtils;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
    public int shortestDistance2(String[] words, String word1, String word2) {
        int ret = Integer.MAX_VALUE, index1 = -1, index2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
                if(index2 >= 0) ret = Math.min(ret, i - index2);
            } else if(words[i].equals(word2)) {
                index2 = i;
                if(index1 >= 0) ret = Math.min(ret, i - index1);
            }
        }
        return ret;
    }
}
