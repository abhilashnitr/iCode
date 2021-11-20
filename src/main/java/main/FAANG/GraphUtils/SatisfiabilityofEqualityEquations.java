package main.FAANG.GraphUtils;

/*
Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4
and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different)
that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

*/

public class SatisfiabilityofEqualityEquations {

    public static void main(String[] args) {
        String[] strs={"b==a","a!=b"};
        SatisfiabilityofEqualityEquations s=new SatisfiabilityofEqualityEquations();
        System.out.println(s.equationsPossible(strs));
    }
    int[] parent;
    int find(int x) {
        return parent[x] == x ? x : find(parent[x]);
    }

    boolean equationsPossible(String[] equations) {
        int n = equations.length;
        parent =new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '=') {
                int x = find(equations[i].charAt(0)-'a');
                int y = find(equations[i].charAt(3)-'a');
                if (x != y)
                    parent[y] = x;
            }
        }
        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '!') {
                int x = find(equations[i].charAt(0)-'a');
                int y = find(equations[i].charAt(3)-'a');
                if (x == y)
                    return false;
            }
        }
        return true;
    }
}
